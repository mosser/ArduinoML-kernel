tests
testDSLForBricks
	| myApp |
	myApp := AMLApp new.
	myApp
		bricks:
			{#button sensorOnPin: 9.
			#led actuatorOnPin: 12}.
	self assert: myApp bricks size = 2