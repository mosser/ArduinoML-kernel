tests
testAnEmptyAMLAppHasNoStates
	| myApp |
	myApp := AMLApp new.
	self assert: myApp states isEmpty