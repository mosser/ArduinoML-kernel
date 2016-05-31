visitor
visitApp: anAMLApp
	anAMLApp bricks do: [ :each | self formatGlobalVariable: each ].
	self formatSetup: anAMLApp.
	self formatLoop: anAMLApp