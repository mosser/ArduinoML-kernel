tests
testFormatCallFirstFunctionInLoop
	| result app |
	app := #myApp arduinoApp
    bricks:
        {#button sensorOnPin: 9.
        #led actuatorOnPin: 12};
    states:{
        #offline stateDo: {#led setTo: #LOW}.
        #online stateDo: {#led setTo: #HIGH}};
    transitions:{
        #offline to: #online when: (#button is: #HIGH).
        #online to: #offline when: (#button is: #LOW).
        };
    build.
	result := AMLArduinoCodeVisitor new formatInitialState: app states first.
	self assert: result contents equals: 'state_offline();'