as yet unclassified
formatLoop: anAMLApp
	stream nextPutAll: 'void loop(){'.
	anAMLApp states isNotEmpty ifTrue:[
	self formatInitialState: anAMLApp states first].
	stream nextPutAll: '}'