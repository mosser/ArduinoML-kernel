grammar PolyDsl
hidden(WS, SL_COMMENT, ML_COMMENT)


App:
	'app' name=ID 'initial' 'state' initial=[State|ID]
	'{'
		'bricks'
		bricks+=Brick
		(bricks+=Brick)* 
		
		'states'
		states+=State
		(states+=State)* 		
	'}';


Brick:
	(Actuator | Sensor);

Actuator:
	'actuator' name=ID ':' pin=INT;

Sensor:
	'sensor' name=ID ':' pin=INT;
	
State:
	name=ID '{'
		actions+=Action
		(actions+=Action)* 
		transition=Transition
	'}';


Action:
	actuator=[Actuator|ID] '<=' value=Signal;

Transition:
	sensor=[Sensor|ID] 'is' value=Signal '=>' next=[State|ID];

Signal: 
    HIGH = 'HIGH' | LOW = 'LOW';

terminal WS: /\s+/;
terminal ID: /[_a-zA-Z][\w_]*/;
terminal INT returns number: /[0-9]+/;
terminal STRING: /"[^"]*"|'[^']*'/;

terminal ML_COMMENT: /\/\*[\s\S]*?\*\//;
terminal SL_COMMENT: /\/\/[^\n\r]*/;