
// Structural concepts
int BUTTON = 9;
int LED = 12;

void setup() {
  pinMode(BUTTON, INPUT);
  pinMode(LED,    OUTPUT);
}

// Behavioral concepts
int state = LOW; int prev = HIGH;
long time = 0; long debounce = 200;

void loop() {
  int reading = digitalRead(BUTTON);
  if (reading == HIGH && prev == LOW && millis() - time > debounce) { 
    if (state == HIGH) { state = LOW; } else { state = HIGH; } 
    time = millis();
  }
  digitalWrite(LED, state); 
  prev = reading;
}
