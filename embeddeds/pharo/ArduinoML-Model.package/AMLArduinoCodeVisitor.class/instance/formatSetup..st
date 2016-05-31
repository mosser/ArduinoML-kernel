as yet unclassified
formatSetup: anAMLApp
	stream nextPutAll: 'void setup(){'.
	anAMLApp bricks do: [ :each | self formatSetupPinMode: each ].
	stream nextPutAll: '}'