tests
testNoBricksGenerateEmptySetup
	| result app |
	app := AMLApp new.
	result := AMLArduinoCodeVisitor new formatSetup: app.
	self assert: result contents equals: 'void setup(){}'