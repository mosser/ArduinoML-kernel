visitor
visitApp: anAMLApp
	anAMLApp bricks do: [ :each | self formatGlobalVariable: each ].
	self formatSetup: anAMLApp.
	anAMLApp states do: [ :each | self formatState: each ].
	self formatLoop: anAMLApp