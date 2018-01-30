module ArduinoML.Wire

import ArduinoML.Model
import Data.Union

%access public export

pad : Nat -> String -> String
pad = (++) . pack . flip replicate ' '

displayParams : List String -> String
displayParams = concat . intersperse ", "

var : String -> String -> String -> String
var ty varName value = ty ++ " " ++ varName ++ " = " ++ value ++ ";"

call : String -> List String -> String
call funcName params = funcName ++ "(" ++ displayParams params ++ ");"

func : String -> String -> List String -> List String -> String
func ty funcName params content = unlines $
  (ty ++ " " ++ funcName ++ "(" ++ displayParams params ++ ") {")
  :: map (pad 2) content
  ++ ["}"]
             

brickWireDecl : Brick -> String
brickWireDecl x = var "int" (name x) (show $ pin x)

brickSetupLine : Brick -> String
brickSetupLine x = let
  mode = case x of
              MemberHere _ => "INPUT"
              MemberThere _ => "OUTPUT"
  in call "pinMode" [ name x, mode ]

bricksWireIO : List Brick -> String
bricksWireIO = func "void" "setup" [] . map brickSetupLine

initApp : String
initApp = unwords
  [ var "long" "time" "0"
  , var "long" "debounce" "200"
  ]

actionToWire : Action -> String
actionToWire a = call "digitalWrite" [ name (actuator a)
                                     , show (value a)
                                     ]

stateWireName : State -> String
stateWireName = ("state_" ++) . name

transitionCondition : Transition -> String
transitionCondition tr = "digitalRead(" ++ name (sensor tr) ++ ") == "
                      ++ show (value tr)

transitionToWire : State -> List String
transitionToWire s = let
  tr = transition s
  in [ "if (" ++ transitionCondition tr ++ " && guard) {"
     , "  time = millis();"
     , pad 2 $ call (stateWireName $ next tr) []
     , "} else {"
     , pad 2 $ call (stateWireName s) []
     , "}"
     ]


stateToWire : State -> String
stateToWire s = func "void " (stateWireName s) [] $
  map actionToWire (actions s)
  ++  ( var "boolean" "guard" "millis() - time > debounce"
      :: transitionToWire s
      )

initialToWire : State -> String
initialToWire s = "void loop() { " ++ stateWireName s ++ "(); }"

appToWire : Application -> String
appToWire x = unlines $
  map brickWireDecl (bricks x)
  ++ [ bricksWireIO (bricks x)
     , initApp
     ]
  ++ map stateToWire (states x)
  ++ pure (initialToWire (initial x))
