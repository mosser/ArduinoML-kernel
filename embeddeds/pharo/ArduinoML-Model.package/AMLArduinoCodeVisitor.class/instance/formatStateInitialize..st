formatting
formatStateInitialize: anAMLAction
	stream nextPutAll: 'digitalWrite('.
	stream
		nextPutAll: anAMLAction actuator amlName;
		nextPutAll: ', ';
		nextPutAll: anAMLAction signalValue.
	stream nextPutAll: ');'