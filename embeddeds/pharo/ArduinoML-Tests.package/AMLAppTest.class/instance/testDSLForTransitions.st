tests
testDSLForTransitions
	| myApp |
	myApp := #myApp arduinoApp
		bricks:
			{#button sensorOnPin: 9.
			#led actuatorOnPin: 12};
		states:
			{#offline stateDo: {#led setTo: #LOW}.
			#online stateDo: {#led setTo: #HIGH}};
		transitions:
			{#offline to: #online when: (#button is: #HIGH).
			#online to: #offline when: (#button is: #LOW)};
		build.
	self
		assert: myApp states first transition sensor class
		equals: AMLSensor