tests
testDSLForStates
	| myApp |
	myApp := #myApp arduinoApp
		bricks:
			{#button sensorOnPin: 9.
			#led actuatorOnPin: 12};
		states:
			{#offline stateDo: {#led setTo: #LOW}.
			#online stateDo: {#led setTo: #HIGH}};
		build.
	self
		assert: myApp states first actions first actuator class
		equals: AMLActuator