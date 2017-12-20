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
	anAMLState actions isNotEmpty
		ifTrue: [ stream nextPut: Character cr ].	
	anAMLState transition isNotNil
		ifTrue: [ stream nextPut: Character tab. self formatTransition: anAMLState transition fromState: anAMLState ].
	anAMLState actions isNotEmpty
		ifTrue: [ stream nextPut: Character cr ].
	stream nextPutAll: '}'