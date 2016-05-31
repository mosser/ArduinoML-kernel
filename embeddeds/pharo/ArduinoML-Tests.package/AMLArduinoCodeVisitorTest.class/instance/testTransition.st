tests
testTransition
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
	result := AMLArduinoCodeVisitor new formatTransition: app states first transition fromState: app states first.
	self assert: result contents equals: 'if (digitalRead(button) == HIGH) {state_offline();} else {state_online();}'