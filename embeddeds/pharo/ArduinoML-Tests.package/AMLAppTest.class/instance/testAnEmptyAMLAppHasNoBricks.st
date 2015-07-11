tests
testAnEmptyAMLAppHasNoBricks
	| myApp |
	myApp := AMLApp new.
	self assert: myApp bricks isEmpty