tests
testFormatGlobalVariable
	| result app |
	app := #myApp arduinoApp
		bricks: {#led actuatorOnPin: 12};
		build.
	result := AMLArduinoCodeVisitor new formatGlobalVariable: app bricks first.
	self assert: result contents equals: 'int led = 12;'