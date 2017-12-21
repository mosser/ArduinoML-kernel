formatting
formatSetup: anAMLApp
	stream nextPutAll: 'long time = 0;'.
	stream nextPut: Character cr.
	stream nextPutAll: 'long debounce = 200;'.
	stream nextPut: Character cr.
	stream nextPut: Character cr.
	super formatSetup: anAMLApp