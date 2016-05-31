tests
testAStateWithoutTransitionsAndActionGenerateAnEmptyFunction
	| result state |
	state := (AMLState new) amlName: 'on'.
	result := AMLArduinoCodeVisitor new visitState: state.
	self assert: result contents equals: 'void state_on(){}'