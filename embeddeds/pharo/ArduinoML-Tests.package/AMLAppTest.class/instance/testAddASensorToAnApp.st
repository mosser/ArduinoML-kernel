tests
testAddASensorToAnApp
	| myApp |
	myApp := AMLApp new.
	myApp addBrick: (AMLSensor new pin: 9).
	self assert: myApp bricks size equals: 1