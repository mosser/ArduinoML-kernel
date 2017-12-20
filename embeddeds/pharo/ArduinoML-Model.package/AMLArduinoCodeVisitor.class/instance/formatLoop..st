formatting
formatLoop: anAMLApp
	stream nextPutAll: 'void loop(){'.
	anAMLApp states isNotEmpty ifTrue:[
	stream nextPut: Character cr.
	stream nextPut: Character tab.
	self formatInitialState: anAMLApp states first.
	stream nextPut: Character cr.].
	stream nextPutAll: '}'