tests
testFormatSetupPinModeForSensor
	| result app |
	app := #myApp arduinoApp
		bricks: {#button sensorOnPin: 9};
		build.
	result := AMLArduinoCodeVisitor new formatSetupPinMode: app bricks first.
	self assert: result contents equals: 'pinMode(button, INPUT);'