formatting
formatSetupPinMode: anAMLBrick
	stream nextPutAll: 'pinMode('.
	stream nextPutAll: anAMLBrick amlName.
	stream nextPutAll: ', '.
	stream
		nextPutAll:
			(anAMLBrick isSensor
				ifTrue: [ 'INPUT' ]
				ifFalse: [ 'OUTPUT' ]).
	stream nextPutAll: ');'