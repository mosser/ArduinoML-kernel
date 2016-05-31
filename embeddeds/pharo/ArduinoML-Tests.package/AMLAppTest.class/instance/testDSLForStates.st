tests
testDSLForStates
	| myApp |
	myApp := #myApp arduinoApp
		bricks:
			{#button sensorOnPin: 9.
			#led actuatorOnPin: 12};
		states:
			{#offline stateDo: {#led setTo: #low}.
			#online stateDo: {#led setTo: #high}};
		build.
	self
		assert: myApp states first actions first actuator class
		equals: AMLActuator