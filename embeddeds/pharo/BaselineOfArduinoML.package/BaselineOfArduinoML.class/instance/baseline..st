baseline
baseline: spec
	<baseline>
	spec
		for: #common
		do: [ 
			spec
				package: 'ArduinoML-Model';
				package: 'ArduinoML-DSL' with: [ spec requires: 'ArduinoML-Model' ];
				package: 'ArduinoML-Tests' with: [ spec requires: 'ArduinoML-DSL' ].
			spec
				group: 'Default' with: #('ArduinoML-Model' 'ArduinoML-DSL');
				group: 'Tests' with: #('ArduinoML-Tests').]
