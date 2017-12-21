formatting
formatState: anAMLState
	stream nextPutAll: 'void state_'.
	stream nextPutAll: anAMLState amlName.
	stream nextPutAll: '(){'.
	anAMLState actions isNotEmpty
		ifTrue: [ stream nextPut: Character cr ].
	anAMLState actions
		do: [ :each | 
			stream nextPut: Character tab.
			self formatStateInitialize: each ].
	stream nextPut: Character cr.
	stream nextPut: Character tab.
	stream nextPutAll: 'boolean guard = millis() - time > debounce;'.
	anAMLState actions isNotEmpty
		ifTrue: [ stream nextPut: Character cr ].	
	anAMLState transition isNotNil
		ifTrue: [ stream nextPut: Character tab. self formatTransition: anAMLState transition fromState: anAMLState ].
	anAMLState actions isNotEmpty
		ifTrue: [ stream nextPut: Character cr ].
	stream nextPutAll: '}'.
	stream nextPut: Character cr