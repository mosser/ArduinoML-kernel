as yet unclassified
formatInitialState: anAMLState
	stream nextPutAll: 'state_'.
	stream nextPutAll: (anAMLState amlName); nextPutAll: '();'
	
