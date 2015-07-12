// Structural concepts
void setup() {
  pinMode( 9, INPUT);
  pinMode(12, OUTPUT);
}

// Behavioral concepts
long time = 0; long debounce = 200;

void state_on() { 
  digitalWrite(12, HIGH);
  boolean guard =  millis() - time > debounce;  
  if (digitalRead(9) == HIGH  && guard ) { 
    time = millis(); state_off(); 
  } else { 
    state_on(); 
  }
}

void state_off() {
  digitalWrite(12, LOW);
  boolean guard =  millis() - time > debounce;   
  if (digitalRead(9) == HIGH  && guard) { 
    time = millis(); state_on(); 
  } else { 
    state_off(); 
  }
}

void loop() { state_off(); } // entering init state
