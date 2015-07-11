*ArduinoML-DSL
setTo: aValue
	^ AMLAction new
		actuator: self;
		signalValue: aValue