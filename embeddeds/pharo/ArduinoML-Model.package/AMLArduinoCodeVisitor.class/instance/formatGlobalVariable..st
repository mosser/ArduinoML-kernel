as yet unclassified
formatGlobalVariable: anAMLBrick
	stream nextPutAll: 'int '.
	stream nextPutAll: anAMLBrick amlName.
	stream nextPutAll: ' = '.
	stream nextPutAll: (anAMLBrick pin) asString.
	stream nextPutAll: ';'