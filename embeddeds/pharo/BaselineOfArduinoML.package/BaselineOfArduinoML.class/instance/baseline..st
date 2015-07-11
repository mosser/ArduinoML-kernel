baseline
baseline: spec
	<baseline>
	spec
		for: #common
		do: [ 
			spec
				package: 'ArduinoML-Model' with: [ spec requires: 'Moose' ];
				package: 'ArduinoML-DSL' with: [ spec requires: 'ArduinoML-Model' ];
				package: 'ArduinoML-Tests' with: [ spec requires: 'ArduinoML-DSL' ].
			spec
				group: 'Default' with: #('ArduinoML-Model' 'ArduinoML-DSL');
				group: 'Tests' with: #('ArduinoML-Tests').
			spec
				project: 'Moose'
				with: [ 
					spec
						className: 'ConfigurationOfMoose';
						version: '5.1';
						repository: 'http://smalltalkhub.com/mc/Moose/Moose/main' ] ]