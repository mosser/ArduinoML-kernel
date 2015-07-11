tests
testDSLForTransitions
	| myApp |
	myApp := #myApp arduinoApp
		bricks:
				{#button sensorOnPin: 9.
					#led actuatorOnPin: 12};
		states:{
				#offline stateDo: {#led setTo: #low}.
					#online stateDo: {#led setTo: #high}};
		transitions:{
			#offline to: #online when: (#button is: #high).
			#online to: #offline when: (#button is: #low).
		};
		build.
	self assert: (myApp states) first transition sensor class = AMLSensor