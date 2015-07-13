{-# LANGUAGE TemplateHaskell #-}

{- |
Module: Arduino.Model
Description: Model of an Arduino ML Kernel
Copyright: © Nicolas Biri, 2015

License: GPL-3
Maintainer: nicolas@biri.name
-}
module ArduinoHS.Model (
    -- * Datatypes
    App (App) -- ^ Global app description
  , State (State) -- ^ State definition
  , Action (Action) -- ^ Action associated to a State
  , Transition (Transition) -- ^ Change State on Actuator ativation
  , Brick (..) -- ^ Sensors and actuators
  , BrickLegacy (BrickLegacy) -- ^ globla brick information
  , Sensor (Sensor) -- ^ Sensor connected to the application
  , Actuator (Actuator) -- ^ Actuator connected to the application
  , Signal (..) -- ^ Actuators signal
    -- * constructors
  , sensor   -- ^ create a sensor brick more easily
  , actuator -- ^ create an actuator brick more easily
    -- * Lenses
  , appName -- ^ Name of an app
  , initialState -- ^ The initialState of the app
  , states  -- ^ The states of an app
  , bricks  -- ^ The bricks of an app
  , stateName -- ^ Name of a state
  , actions -- ^ Actions of a state
  , transitions -- ^ Transitions of a state
  , actionValue -- ^ Signal value set by an action
  , refActuator -- ^ The actuator manipulated through an action
  , transitionValue -- ^ the value that triggers the transition
  , refSensor -- ^ the sensor that triggers the transition
  , next -- ^ the state targeted by the transition
  , brickName -- ^ name of a brick
  , brickPort -- ^ port of a brick
  , actuatorName -- ^ name of an actuator
  , sensorName -- ^ name of a sensor
  ) where

import Control.Applicative
import Control.Lens (makeLenses, makePrisms, Lens', lens, view, views, has, _Right, set)

import qualified Data.List.NonEmpty as NE

import Numeric.Natural

data App
  = App
  { _appName      :: String
  , _initialState :: State
  , _states       :: [State]
  , _bricks       :: NE.NonEmpty Brick
  } deriving (Eq, Show, Read)

data State
  = State
  { _stateName   :: String
  , _actions     :: [Action]
  , _transitions :: [Transition]
  } deriving (Eq, Show, Read)

data Action
  = Action
  { _actionValue :: Signal
  , _refActuator :: Actuator
  } deriving (Eq, Show, Read)

data Transition
  = Transition
  { _transitionValue :: Signal
  , _refSensor :: Sensor
  , _next :: State
  } deriving (Eq, Show, Read)

data Brick
  = BrickSensor Sensor
  | BrickActuator Actuator
  deriving (Eq, Show, Read)

data BrickLegacy
  = BrickLegacy
  { _brickName :: String
  , _brickPin :: Natural
  } deriving (Eq, Show, Read)

data Sensor = Sensor BrickLegacy
  deriving (Eq, Show, Read)

sensor :: String -> Natural -> Brick
sensor n p = BrickSensor . Sensor $ BrickLegacy n p

data Actuator = Actuator BrickLegacy
  deriving (Eq, Show, Read)

actuator :: String -> Natural -> Brick
actuator n p = BrickActuator . Actuator $ BrickLegacy n p

data Signal = Low | High
  deriving (Eq, Show, Read)

makeLenses ''App
makeLenses ''State
makeLenses ''Action
makeLenses ''Transition

makePrisms ''Brick

actuatorName :: Lens' Actuator String
actuatorName = lens getter setter
 where
   getter (Actuator (BrickLegacy n _)) = n
   setter (Actuator (BrickLegacy _ p)) n = Actuator $ BrickLegacy n p

sensorName :: Lens' Sensor String
sensorName = lens getter setter
 where
   getter (Sensor (BrickLegacy n _)) = n
   setter (Sensor (BrickLegacy _ p)) n = Sensor $ BrickLegacy n p

brickName :: Lens' Brick String
brickName = lens getter setter
  where
    getter (BrickSensor   s) = view sensorName s
    getter (BrickActuator a) = view actuatorName a
    setter (BrickSensor   s) n = BrickSensor   $ set sensorName n s
    setter (BrickActuator a) n = BrickActuator $ set actuatorName n a

brickPort :: Lens' Brick Natural
brickPort = lens getter setter
  where
    getter (BrickSensor   (Sensor   (BrickLegacy _ p))) = p
    getter (BrickActuator (Actuator (BrickLegacy _ p))) = p
    setter (BrickSensor   (Sensor   (BrickLegacy n _))) p
      = BrickSensor   (Sensor   (BrickLegacy n p))
    setter (BrickActuator (Actuator (BrickLegacy n _))) p
      = BrickActuator (Actuator (BrickLegacy n p))
