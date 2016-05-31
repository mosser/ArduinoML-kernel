examples
example1
	| myApp result |
myApp := #myApp arduinoApp
    bricks:
        {#button sensorOnPin: 9.
        #led actuatorOnPin: 12};
    states:{
        #offline stateDo: {#led setTo: #low}.
        #online stateDo: {#led setTo: #high}};
    transitions:{
        #offline to: #online when: (#button is: #high).
        #online to: #offline when: (#button is: #low).
        };
    build.
result := AMLArduinoCodeVisitor new visitApp: myApp.
result contents