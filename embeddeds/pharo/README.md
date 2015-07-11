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

##Install ArduinoML in Pharo 4.0


```Smalltalk
Metacello new
    baseline: 'ArduinoML';
    repository: 'github://SergeStinckwich/ArduinoML-kernel/embeddeds/pharo';
    load
```
