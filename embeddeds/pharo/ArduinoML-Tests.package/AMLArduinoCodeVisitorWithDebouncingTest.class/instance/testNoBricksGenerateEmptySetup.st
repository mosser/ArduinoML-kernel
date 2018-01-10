tests
testNoBricksGenerateEmptySetup
	| result app |
	app := AMLApp new.
	result := AMLArduinoCodeVisitorWithDebouncing new formatSetup: app.
	self assert: result contents equals: 'long time = 0;
long debounce = 200;

void setup(){}'