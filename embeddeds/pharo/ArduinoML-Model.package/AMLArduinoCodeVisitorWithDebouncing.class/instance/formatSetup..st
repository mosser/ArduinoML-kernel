formatting
formatSetup: anAMLApp
	stream nextPutAll: 'void setup(){'.
	anAMLApp bricks do: [ :each | stream nextPut: Character cr. stream nextPut: Character tab. self formatSetupPinMode: each ].
	anAMLApp bricks isNotEmpty ifTrue: [ stream nextPut: Character cr].
	stream nextPutAll: '}'.
	stream nextPut: Character cr.
	stream nextPut: Character cr.
   stream nextPutAll: 'long time = 0;'.
	stream nextPut: Character cr.
   stream nextPutAll: 'long debounce = 200;'.
	stream nextPut: Character cr.
	