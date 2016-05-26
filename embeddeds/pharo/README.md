#ArduinoML for Pharo

#DSL example
```Smalltalk
#myApp arduinoApp
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
```

##Install ArduinoML in Pharo 5.0 (Spur VM)
* Download a Spur VM: https://ci.inria.fr/pharo/view/5.0-VM-Spur/job/PharoVM-spur32/
* Download the last dev MOOSE 6.0 on INRIA's CI server: https://ci.inria.fr/moose/job/moose-6.0/
* Install GitFileTree from Configuration Browser
* Execute in a Playground:
```Smalltalk
Metacello new
    baseline: 'ArduinoML';
    repository: 'github://SergeStinckwich/ArduinoML-kernel/embeddeds/pharo';
    load
```
