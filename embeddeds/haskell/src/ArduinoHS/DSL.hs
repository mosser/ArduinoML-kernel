{-# LANGUAGE AllowAmbiguousTypes #-}
{-# LANGUAGE FlexibleContexts    #-}
{-# LANGUAGE TemplateHaskell     #-}

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
  , initialState
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
  -- * model creation error
  , DSLError
  , InvalidModel (..)
  , InvalidRef (..)
  ) where

import           Control.Applicative
import           Control.Lens (view, views, over)
import qualified Control.Lens         as L
import           Control.Monad (join, mfilter)
import qualified Control.Monad.State  as S
import qualified Control.Monad.Except as E

import qualified Data.Bifunctor       as B
import qualified Data.Map             as M
import qualified Data.List.NonEmpty   as NE

import           Numeric.Natural

import qualified ArduinoHS.Model      as A

data AppBuilder
  = AppBuilder
  { _startState :: Maybe A.State
  , _states :: M.Map String A.State
  , _bricks :: M.Map String A.Brick
  } deriving (Eq, Read, Show)

L.makeLenses ''AppBuilder

emptyBuilder :: AppBuilder
emptyBuilder = AppBuilder Nothing mempty mempty

toApp :: String -> AppBuilder -> Either InvalidModel A.App
toApp _ (AppBuilder Nothing _ _) = Left NoInitialState
toApp n (AppBuilder (Just s) ss mbs) = case M.elems mbs of
  (b:bs) -> Right $ A.App n s (M.elems ss) (b NE.:| bs)
  _      -> Left NoBrick

addSensor :: S.MonadState AppBuilder m
          => String -> Natural -> m ()
addSensor name port
  = S.modify $ over bricks $ M.insert name (A.sensor name port)

addActuator :: S.MonadState AppBuilder m
            => String -> Natural -> m ()
addActuator name port
  = S.modify $ over bricks $ M.insert name (A.actuator name port)

initialState :: (S.MonadState AppBuilder m, E.MonadError DSLError m)
             => String -> m ()
initialState name = do
  s <- S.get
  case (view startState s) of
    Nothing -> S.modify $ L.set startState $ Just $ A.State name [] []
    Just _  -> E.throwError $ liftModelError AmbiguousInitialState

defineState :: S.MonadState AppBuilder m
            => String -> m ()
defineState name = S.modify defineStateS
  where
    defineStateS = over states $ M.insert name (A.State name [] [])

set :: (S.MonadState AppBuilder m, E.MonadError DSLError m)
    => String -> m A.Actuator
set act = do
  b <- S.gets (view $ bricks . L.to (M.lookup act))
  checkBrick b
  where
    checkBrick (Just (A.BrickActuator s)) = return s
    checkBrick Nothing             = E.throwError $ liftRefError $ UnknownBrick act
    checkBrick _                   = E.throwError $ liftRefError $ WrongBrickType act

when :: (S.MonadState AppBuilder m, E.MonadError DSLError m)
     => String -> m A.Sensor
when sen = do
  b <- S.gets (view $ bricks . L.to (M.lookup sen))
  checkBrick b
  where
    checkBrick (Just (A.BrickSensor s)) = return s
    checkBrick Nothing             = E.throwError $ liftRefError $ UnknownBrick sen
    checkBrick _                   = E.throwError $ liftRefError $ WrongBrickType sen

execute :: S.MonadState AppBuilder m => m A.State -> [m A.Action] -> m ()
execute state as = do
  as' <- sequence as
  state' <- over A.actions (++ as') <$> state
  S.modify $ over states (join (M.insert . view A.stateName) state')


are :: S.MonadState AppBuilder m => m A.State -> [m A.Transition] -> m ()
are state ts = do
  ts' <- sequence ts
  state' <- over A.transitions (++ ts') <$> state
  S.modify $ over states (join (M.insert . view A.stateName) state')

is :: S.MonadState AppBuilder m
   => m A.Sensor -> A.Signal -> m A.State -> m A.Transition
is sen sig st = A.Transition <$> pure sig <*> sen <*> st

to :: S.MonadState AppBuilder m => m A.Actuator -> A.Signal -> m A.Action
to act sig = A.Action <$> pure sig <*> act

goto :: (S.MonadState AppBuilder m, E.MonadError DSLError m)
     => String -> m A.State
goto = resolveState

actionsWhen :: (S.MonadState AppBuilder m, E.MonadError DSLError m)
     => String -> m A.State
actionsWhen = resolveState

transitionsFrom :: (S.MonadState AppBuilder m, E.MonadError DSLError m)
     => String -> m A.State
transitionsFrom = resolveState

resolveState :: (S.MonadState AppBuilder m, E.MonadError DSLError m)
     => String -> m A.State
resolveState name = do
  s <- S.gets $ liftA2 (<|>) checkStates checkInitialState
  maybe (E.throwError $ liftRefError $ UnknownState name) return s
    where
      checkStates = view $ states . L.to (M.lookup name)
      checkInitialState = views startState $ mfilter (views A.stateName (== name))

onPort :: Natural -> Natural
onPort = id


buildApp :: String
         -> S.StateT AppBuilder (Either DSLError) ()
         -> Either DSLError A.App
buildApp name plan = do
  builder <- flip S.execStateT emptyBuilder plan
  B.first liftModelError $ toApp name builder

type DSLError = Either InvalidModel InvalidRef

liftModelError :: InvalidModel -> DSLError
liftModelError = Left

liftRefError :: InvalidRef -> DSLError
liftRefError = Right

data InvalidModel
  = NoInitialState
  | NoBrick
  | AmbiguousInitialState
  deriving (Eq, Show, Read)

data InvalidRef
  = UnknownState String
  | UnknownBrick String
  | WrongBrickType String
  deriving (Eq, Show, Read)
