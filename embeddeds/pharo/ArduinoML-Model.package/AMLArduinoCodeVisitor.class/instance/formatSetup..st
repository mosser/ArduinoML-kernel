formatting
formatSetup: anAMLApp
	stream nextPutAll: 'void setup(){'.
	anAMLApp bricks do: [ :each | stream nextPut: Character cr. stream nextPut: Character tab. self formatSetupPinMode: each ].
	anAMLApp bricks isNotEmpty ifTrue: [ stream nextPut: Character cr].
	stream nextPutAll: '}'