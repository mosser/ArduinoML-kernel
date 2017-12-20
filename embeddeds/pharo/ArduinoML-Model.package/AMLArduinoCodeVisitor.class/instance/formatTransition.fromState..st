formatting
formatTransition: anAMLTransition fromState: anAMLState
	stream nextPutAll: 'if (digitalRead('.
	stream nextPutAll: anAMLTransition sensor amlName.
	stream nextPutAll: ') == '.
	stream nextPutAll: anAMLTransition signalValue.
	stream nextPutAll: ') '.
	stream nextPutAll: '{state_'.
	stream nextPutAll: anAMLState amlName.
	stream nextPutAll: '();}'.
	stream nextPutAll: ' else {state_'.
	stream nextPutAll: anAMLTransition next amlName.
	stream nextPutAll: '();}'