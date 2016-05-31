examples
example1
	| myApp result |
myApp := #myApp arduinoApp
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
result := AMLArduinoCodeVisitor new visitApp: myApp.
result contents