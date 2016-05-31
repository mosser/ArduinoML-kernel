tests
testFormatSetupPinModeForActuator
	| result app |
	app := #myApp arduinoApp
		bricks: {#led actuatorOnPin: 12};
		build.
	result := AMLArduinoCodeVisitor new formatSetupPinMode: app bricks first.
	self assert: result contents equals: 'pinMode(led, OUTPUT);'