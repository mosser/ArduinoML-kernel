as yet unclassified
baseline: spec
	<baseline>
	spec
		for: #common
		do: [ 
			spec package: 'ArduinoML' with: [ spec requires: 'Moose' ].
			spec
				project: 'Moose'
				with: [ 
					spec
						className: 'ConfigurationOfMoose';
						version: '5.1';
						repository: 'http://smalltalkhub.com/mc/Moose/Moose/main' ] ]