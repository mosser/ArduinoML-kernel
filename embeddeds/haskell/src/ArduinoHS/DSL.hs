{-# LANGUAGE AllowAmbiguousTypes #-}
{-# LANGUAGE FlexibleContexts    #-}
{-# LANGUAGE ImpredicativeTypes  #-}
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
  , start
  , defineState
  , defineStates
  -- * brick definition
  , addSensor
  , addActuator
  , onPin
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

import qualified Data.Foldable        as F
import qualified Data.Map             as M
import qualified Data.List.NonEmpty   as NE

import           Numeric.Natural

import qualified ArduinoHS.Model      as A

data AppBuilder
  = AppBuilder
  { _startStateName :: Maybe String
  , _states :: M.Map String A.State
  , _bricks :: M.Map String A.Brick
  } deriving (Eq, Read, Show)

L.makeLenses ''AppBuilder

emptyBuilder :: AppBuilder
emptyBuilder = AppBuilder Nothing mempty mempty

toApp :: E.MonadError DSLError m => String -> AppBuilder -> m A.App
toApp _ (AppBuilder Nothing _ _) = E.throwError $ liftModelError NoInitialState
toApp n (AppBuilder (Just s) ss mbs) = case M.elems mbs of
  (b:bs) -> A.App n <$> findInitialState ss
                    <*> pure (M.elems $ M.delete s ss)
                    <*> pure (b NE.:| bs)
    where
      initialStateNotFound = E.throwError . liftRefError $ InitialStateDoesntExist n
      findInitialState = maybe initialStateNotFound return . M.lookup s
  _      -> E.throwError $ liftModelError NoBrick

addSensor :: S.MonadState AppBuilder m
          => String -> Natural -> m ()
addSensor name port = bricks . L.at name L.?= A.sensor name port

addActuator :: S.MonadState AppBuilder m
            => String -> Natural -> m ()
addActuator name port = bricks . L.at name L.?= A.actuator name port

initialState :: (S.MonadState AppBuilder m, E.MonadError DSLError m)
             => String -> m ()
initialState name = do
  s <- S.get
  case view startStateName s of
    Nothing -> startStateName L..= Just name
    Just _  -> E.throwError $ liftModelError AmbiguousInitialState

start :: (S.MonadState AppBuilder m, E.MonadError DSLError m)
      => String -> m ()
start = initialState

defineState :: (S.MonadState AppBuilder m, E.MonadError DSLError m)
            => String -> m ()
defineState name = (S.get >>= checkState name) >> defineStateS
  where
    defineStateS = states . L.at name L.?= newState name

defineStates :: (S.MonadState AppBuilder m, E.MonadError DSLError m)
            => [String] -> m ()
defineStates = F.traverse_ defineState

newState :: String -> A.State
newState name = A.State name mempty mempty

set :: (S.MonadState AppBuilder m, E.MonadError DSLError m)
    => String -> m A.Actuator
set act = do
  b <- S.gets (view $ bricks . L.at act)
  checkBrick b
  where
    checkBrick (Just (A.BrickActuator s)) = return s
    checkBrick Nothing = E.throwError $ liftRefError $ UnknownBrick act
    checkBrick _       = E.throwError $ liftRefError $ WrongBrickType act

when :: (S.MonadState AppBuilder m, E.MonadError DSLError m)
     => String -> m A.Sensor
when sen = S.gets (view $ bricks . L.at sen) >>= checkBrick
  where
    checkBrick (Just (A.BrickSensor s)) = return s
    checkBrick Nothing             = E.throwError $ liftRefError $ UnknownBrick sen
    checkBrick _                   = E.throwError $ liftRefError $ WrongBrickType sen

execute :: S.MonadState AppBuilder m
        => m ((A.State -> A.State) -> AppBuilder -> AppBuilder)
        -> [m A.Action]
        -> m ()
execute mf as = do
  f <- mf
  as' <- sequence as
  L.sets f . A.actions L.<>= as'

are :: S.MonadState AppBuilder m
    => m ((A.State -> A.State) -> AppBuilder -> AppBuilder)
    -> [m A.Transition]
    -> m ()
are mf ts = do
  f <- mf
  ts' <- sequence ts
  L.sets f . A.transitions L.<>= ts'

is :: S.MonadState AppBuilder m
   => m A.Sensor -> A.Signal -> m A.State -> m A.Transition
is sen sig st = A.Transition <$> pure sig <*> sen <*> st

to :: S.MonadState AppBuilder m => m A.Actuator -> A.Signal -> m A.Action
to act sig = A.Action <$> pure sig <*> act

goto :: (S.MonadState AppBuilder m, E.MonadError DSLError m)
     => String -> m A.State
goto name = do
  s <- S.gets checkStates
  maybe (E.throwError $ liftRefError $ UnknownState name) return s
    where
      checkStates = view $ states . L.at name

actionsWhen :: (S.MonadState AppBuilder m, E.MonadError DSLError m)
            => String -> m ((A.State -> A.State) -> AppBuilder -> AppBuilder)
actionsWhen = resolveState

transitionsFrom :: (S.MonadState AppBuilder m, E.MonadError DSLError m)
                => String -> m ((A.State -> A.State) -> AppBuilder -> AppBuilder)
transitionsFrom = resolveState

checkState :: E.MonadError DSLError m
           => String -> AppBuilder -> m ()
checkState name = maybe (return ()) (const err) . nameExists
  where
    err = E.throwError . liftModelError $ AmbiguousState name
    nameExists = L.preview (L.folded . L.only name) . statesName

resolveState :: (S.MonadState AppBuilder m, E.MonadError DSLError m)
             => String -> m ((A.State -> A.State) -> AppBuilder -> AppBuilder)
resolveState name = do
  s <- S.gets checkStates
  maybe (E.throwError $ liftRefError $ UnknownState name) return s
    where
      checkStates a = do
        _ <- L.view (states . L.at name) a
        return $ over (states . L.at name . L._Just)


onPin :: Natural -> Natural
onPin = id

buildApp :: String
         -> S.StateT AppBuilder (Either DSLError) ()
         -> Either DSLError A.App
buildApp name plan = do
  builder <- S.execStateT plan emptyBuilder
  toApp name builder

statesName :: AppBuilder -> [String]
statesName = views states M.keys

type DSLError = Either InvalidModel InvalidRef

liftModelError :: InvalidModel -> DSLError
liftModelError = Left

liftRefError :: InvalidRef -> DSLError
liftRefError = Right

data InvalidModel
  = NoInitialState
  | NoBrick
  | AmbiguousInitialState
  | AmbiguousState String
  deriving (Eq, Show, Read)

data InvalidRef
  = UnknownState String
  | UnknownBrick String
  | WrongBrickType String
  | InitialStateDoesntExist String
  deriving (Eq, Show, Read)
