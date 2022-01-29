
		//Wiring code generated from an ArduinoML model
		// Application name: RedButton
        
		long debounce = 200;
		enum STATE {off, on};
		
		() => {
            if (app.initial != null) {
                return `STATE currentState = ${app.initial}`;
            }
            else {
                return '';
            }
        }

		() => {
            return app.bricks.map(brick => this.declareBrick(brick)).join("\n");
        }


		void setup(){
            () => {
            return app.bricks.map(brick => this.compileBrick(brick)).join("\n");
        }
		}

		void loop() {
			switch(currentState){
                () => {
            return app.states.map(state => this.compileState(state)).join("\n");
        }
			}
		}
        