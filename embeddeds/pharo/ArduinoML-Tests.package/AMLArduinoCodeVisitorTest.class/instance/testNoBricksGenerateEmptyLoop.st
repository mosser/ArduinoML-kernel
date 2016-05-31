tests
testNoBricksGenerateEmptyLoop
	| result app |
	app := AMLApp new.
	result := AMLArduinoCodeVisitor new formatLoop: app.
	self assert: result contents equals: 'void loop(){}'