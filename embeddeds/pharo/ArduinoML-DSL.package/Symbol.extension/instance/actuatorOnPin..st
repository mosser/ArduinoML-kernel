*ArduinoML-DSL
actuatorOnPin: aPinNumber
	^ AMLActuator new
		pin: aPinNumber;
		amlName: self