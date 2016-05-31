tests
testDSLForBricks
	| myApp |
	myApp := #myApp arduinoApp
		bricks:
			{#button sensorOnPin: 9.
			#led actuatorOnPin: 12};
		build.
	self assert: myApp bricks size equals: 2