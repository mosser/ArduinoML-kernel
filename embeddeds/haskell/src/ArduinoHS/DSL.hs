{-# LANGUAGE FlexibleContexts #-}
{-# LANGUAGE AllowAmbiguousTypes #-}

{- |
Module: Arduino.DSL
Description: DSL to model a Arduino Kernel
Copyright: © Nicolas Biri, 2015

License: GPL-3
Maintainer: nicolas@biri.name
-}
module ArduinoHS.DSL
  ( -- * Execute an App plan to build an App
    buildApp
  -- * state definition
  , defineState
  -- * brick definition
  , addSensor
  , addActuator
  , onPort
  -- * action definition
  , actionsWhen
  , execute
  , set
  , to
  -- * transition definition
  , transitionsFrom
  , are
  , when
  , is
  , goto
  ) where

import           Control.Lens (view, over)
import qualified Control.Lens         as L
import           Control.Monad (join)
import qualified Control.Monad.State  as S
import qualified Control.Monad.Except as E

import qualified Data.Map             as M

import           Numeric.Natural

import           ArduinoHS.Model

addSensor :: S.MonadState App m
          => String -> Natural -> m ()
addSensor name port
  = S.modify $ over bricks $ M.insert name (sensor name port)

addActuator :: S.MonadState App m
            => String -> Natural -> m ()
addActuator name port
  = S.modify $ over bricks $ M.insert name (actuator name port)

defineState :: S.MonadState App m
            => String -> m ()
defineState name = S.modify defineStateS
  where
    defineStateS = over states $ M.insert name (State name [] [])

set :: (S.MonadState App m, E.MonadError InvalidRef m)
    => String -> m Actuator
set act = do
  b <- S.gets (view $ bricks . L.to (M.lookup act))
  checkBrick b
  where
    checkBrick (Just (BrickActuator s)) = return s
    checkBrick Nothing             = E.throwError $ UnknownBrick act
    checkBrick _                   = E.throwError $ WrongBrickType act

when :: (S.MonadState App m, E.MonadError InvalidRef m)
     => String -> m Sensor
when sen = do
  b <- S.gets (view $ bricks . L.to (M.lookup sen))
  checkBrick b
  where
    checkBrick (Just (BrickSensor s)) = return s
    checkBrick Nothing             = E.throwError $ UnknownBrick sen
    checkBrick _                   = E.throwError $ WrongBrickType sen

execute :: (S.MonadState App m, E.MonadError InvalidRef m)
        => m State -> [m Action] -> m ()
execute state as = do
  as' <- sequence as
  state' <- over actions (++ as') <$> state
  S.modify $ over states (join (M.insert . view stateName) state')


are :: (S.MonadState App m, E.MonadError InvalidRef m)
    => m State -> [m Transition] -> m ()
are state ts = do
  ts' <- sequence ts
  state' <- over transitions (++ ts') <$> state
  S.modify $ over states (join (M.insert . view stateName) state')

goto :: (S.MonadState App m, E.MonadError InvalidRef m)
     => String -> m State
goto = resolveState

is :: (S.MonadState App m, E.MonadError InvalidRef m)
   => m Sensor -> Signal -> m State -> m Transition
is sen sig st = Transition <$> pure sig <*> sen <*> st

to :: (S.MonadState App m, E.MonadError InvalidRef m)
   => m Actuator -> Signal -> m Action
to act sig = Action <$> pure sig <*> act

actionsWhen :: (S.MonadState App m, E.MonadError InvalidRef m)
     => String -> m State
actionsWhen = resolveState

transitionsFrom :: (S.MonadState App m, E.MonadError InvalidRef m)
     => String -> m State
transitionsFrom = resolveState

resolveState :: (S.MonadState App m, E.MonadError InvalidRef m)
     => String -> m State
resolveState name = do
  s <- S.gets (view $ states . L.to (M.lookup name))
  maybe (E.throwError $ UnknownState name) return s

onPort :: Natural -> Natural
onPort = id


buildApp :: String
         -> S.StateT App (Either InvalidRef) ()
         -> Either InvalidRef App
buildApp name = flip S.execStateT (App name mempty mempty)

data InvalidRef
  = UnknownState String
  | UnknownBrick String
  | WrongBrickType String
  deriving (Eq, Show, Read)
