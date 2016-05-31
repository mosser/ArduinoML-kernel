as yet unclassified
formatLoop: anAMLApp
	stream nextPutAll: 'void loop(){'.
	self formatInitialState: anAMLApp states first.
	stream nextPutAll: '}'