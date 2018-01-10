formatting
formatTransition: anAMLTransition fromState: anAMLState
	stream nextPutAll: 'if (digitalRead('.
	stream nextPutAll: anAMLTransition sensor amlName.
	stream nextPutAll: ') == '.
	stream nextPutAll: anAMLTransition signalValue.
	stream nextPutAll: ' && guard){'.
	stream nextPut: Character cr.
	stream nextPut: Character tab.
	stream nextPut: Character tab.
	stream nextPutAll: 'time = millis();'.
	stream nextPut: Character cr.
	stream nextPut: Character tab.
	stream nextPut: Character tab.
   stream nextPutAll: 'state_'.
	stream nextPutAll: anAMLState amlName.
	stream nextPutAll: '();'.
	stream nextPut: Character cr.
	stream nextPut: Character tab.
	stream nextPutAll: '}'.
	stream nextPutAll: ' else {'.
	stream nextPut: Character cr.
	stream nextPut: Character tab.
	stream nextPut: Character tab.
	stream nextPutAll: 'state_'.
	stream nextPutAll: anAMLTransition next amlName.
	stream nextPutAll: '();'.
	stream nextPut: Character cr.
	stream nextPut: Character tab.
	stream nextPutAll: '}'