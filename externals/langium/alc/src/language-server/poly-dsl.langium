grammar PolyDsl
hidden(WS, SL_COMMENT, ML_COMMENT)
generate arduinoML "http://www.polytech.fr/si5/dsl/arduino/ArduinoML"
terminal WS: /\s+/;
terminal ID: /[_a-zA-Z][\w_]*/;
terminal INT returns number: /[0-9]+/;
terminal STRING: /"[^"]*"|'[^']*'/;

terminal ML_COMMENT: /\/\*[\s\S]*?\*\//;
terminal SL_COMMENT: /\/\/[^\n\r]*/;

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
	'actuator';

Sensor returns Sensor:
	{Sensor}
	'sensor';
	
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

Signal returns Signal: 
    HIGH = 'HIGH' | LOW = 'LOW';
