examples
example1
	| myApp result |
	myApp := #myApp arduinoApp
		bricks:
			{(#button sensorOnPin: 9).
			(#led actuatorOnPin: 12)};
		states:
			{(#offline stateDo: {(#led setTo: #low)}).
			(#online stateDo: {(#led setTo: #high)})};
		build.
	result := AMLArduinoCodeVisitor new visitApp: myApp.
	result contents