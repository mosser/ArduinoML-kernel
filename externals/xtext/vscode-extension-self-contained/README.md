# ArduinoML VS Code example

This is a simple integration of the ArduinoML language done in [Xtext](https://www.eclipse.org/Xtext/) for VS Code based on the Microsoft [Language Server Protocol](https://github.com/Microsoft/language-server-protocol).

The base is following simple grammar

```
App returns App:
	'app' name=ID 'initial' 'state' initial=[State|ID]
	'{'
		'bricks'
		bricks+=Brick
		(bricks+=Brick)* 
		
		'states'
		states+=State
		( states+=State)* 		
	'}';

Brick returns Brick:
	(Actuator | Sensor) name=ID ':' pin=INT;

Actuator returns Actuator:
	{Actuator}
	'Actuator';

Sensor returns Sensor:
	{Sensor}
	'Sensor';
	
State returns State:
	name=ID '{'
		actions+=Action
		(actions+=Action)* 
		transition=Transition
	'}';


Action returns Action:
	actuator=[Actuator|ID] '<=' value=Signal;

Transition returns Transition:
	sensor=[Sensor|ID] 'is' value=Signal '=>' next=[State|ID];

enum Signal returns Signal:
					HIGH = 'HIGH' | LOW = 'LOW';
```

A typical example model would look like (Open a new folder in VSCode and create the files)

test1.aml
```
app RedButton initial state off {
	bricks
		Actuator red_led : 12
		Sensor button : 8
	
	states
		off {
			red_led <= LOW
			button is HIGH => on
		}
		on {
			red_led <= HIGH
			button is HIGH => off
		}
}
```


The Xtext integration supports typical Xtext and Language Server features like

* Syntax Highlighting
* Validation
* Goto Definition / Find References
* Hover
* Formatting
* Mark Occurrences
* Open Symbol

It is based on the Itemis example (in a "monkey see monkey done fashion") that can be founded [here](https://github.com/cdietrich/xtext-languageserver-example)
