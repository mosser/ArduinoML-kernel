as yet unclassified
formatState: anAMLState
	stream nextPutAll: 'void state_'.
	stream nextPutAll: anAMLState amlName.
	stream nextPutAll: '(){'.
	stream nextPutAll: '}'