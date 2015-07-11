tests
testDSLForStates
	| myApp |
	myApp := #myApp arduinoApp
		bricks:
				{#button sensorOnPin: 9.
					#led actuatorOnPin: 12};
		states:{
				#offline stateDo: {#led is: #low}.
					#online stateDo: {#led is: #high}};
		build.
	self assert: (myApp states) first actions first actuator class = AMLActuator 