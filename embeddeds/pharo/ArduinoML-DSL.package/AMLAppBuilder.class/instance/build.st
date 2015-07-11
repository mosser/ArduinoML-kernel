as yet unclassified
build
	| app |
	app := AMLApp new
		amlName: appName;
		bricks: bricks.
	states
		do: [ :eachState | 
			eachState actions
				do: [ :eachAction | eachAction actuator: (app bricks detect: [ :each | each amlName == eachAction actuator ]) ] ].
	app states: states.
	^ app