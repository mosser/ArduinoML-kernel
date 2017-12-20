visiting
visitApp: anAMLApp
	anAMLApp bricks do: [ :each | self formatGlobalVariable: each. stream nextPut: Character cr].
	self formatSetup: anAMLApp.
	stream nextPut: Character cr.
	anAMLApp states do: [ :each | self visitState: each. stream nextPut: Character cr].
	self formatLoop: anAMLApp