{-# LANGUAGE OverloadedStrings #-}

{- |
Module: Arduino.Model
Description: Model of an Arduino ML Kernel
Copyright: © Nicolas Biri, 2015

License: GPL-3
Maintainer: nicolas@biri.name
-}
module ArduinoHS.CodeGen
  ( generate
  ) where

import           Control.Applicative
import           Control.Lens (view, views)
import           Control.Monad (guard, join)

import qualified Data.List.NonEmpty as NE
import qualified Data.Text          as T

import           Text.Printf

import           ArduinoHS.Model

generate :: App -> T.Text
generate = T.intercalate "\n" . sequence
  [ const behaviouralConcepts
  , const ""
  , views bricks (generateBricksDecl . NE.toList)
  , const ""
  , views bricks (generateSetup . NE.toList)
  , const ""
  , generateStateFunctions . liftA2 (:) (view initialState) (view states)
  , const ""
  , views initialState generateMainLoop
  ]

behaviouralConcepts :: T.Text
behaviouralConcepts =
  "// Behavioural Concepts\nlong time = 0; long debounce = 200;"

generateBricksDecl :: [Brick] -> T.Text
generateBricksDecl = T.intercalate "\n" . map generateBrickDecl
  where
    generateBrickDecl = T.pack . liftA2 (printf "int %s = %d;") (view brickName) (view brickPort)

generateSetup :: [Brick] -> T.Text
generateSetup =
  T.intercalate "\n" . (setupDecl:) . (++ [setupClose]) . map brickSetup
    where
      setupDecl = "void setup () {"
      brickSetup =
        T.pack . liftA2 (printf "  pinMode(%s, %s);") (view brickName) brickIO
      setupClose = "}"

brickIO :: Brick -> String
brickIO (BrickActuator _) = "OUTPUT"
brickIO (BrickSensor _)   = "INPUT"

generateStateFunctions :: [State] -> T.Text
generateStateFunctions = T.intercalate "\n\n" . map generateStateFunction

generateStateFunction :: State -> T.Text
generateStateFunction = T.intercalate "\n" . join . sequence
  [ return . views stateName stateFunctionStart
  , views actions $ map stateFunctionAction
  , views transitions (fmap (const guardDefinition) . guard . not . null)
  , liftA2 (map . stateFunctionTransition) (view stateName) (view transitions)
  , const $ return "}"
  ]
    where
      stateFunctionStart = T.pack . printf "void state_%s() {"
      stateFunctionAction = T.pack . liftA2 (printf "  digitalWrite(%s, %s);")
        (view $ refActuator . actuatorName)
        (views actionValue show)
      guardDefinition = "  boolean guard = millis() - time > debounce";

stateFunctionTransition :: String -> Transition -> T.Text
stateFunctionTransition origin = T.intercalate "\n" . sequence
  [ transitionGuard
  , views next whenOk
  , const $ elseBlock origin
  ]
    where
      transitionGuard = T.pack . liftA2 (printf guardPattern)
                                        (view $ refSensor . sensorName)
                                        (views transitionValue show)
      guardPattern = "  if (digitalRead(%s) == %s && guard) {"
      whenOk = views stateName (T.pack . printf "    time = millis(); state_%s();")
      elseBlock = T.pack . printf "  } else {\n    state_%s();\n  }"

generateMainLoop :: State -> T.Text
generateMainLoop = views stateName $ T.pack . printf "void loop() { state_%s(); }"
