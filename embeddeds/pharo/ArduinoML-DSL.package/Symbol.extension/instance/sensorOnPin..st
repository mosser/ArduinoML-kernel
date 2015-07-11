*ArduinoML-DSL
sensorOnPin: aPinNumber
	^ AMLSensor new
		pin: aPinNumber;
		amlName: self