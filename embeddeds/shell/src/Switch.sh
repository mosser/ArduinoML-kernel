app 'Switch!'

  sensor BUTTON
    pin 9

  actuator LED
    pin 12

  state off
    change LED to LOW
    when BUTTON has_value HIGH go_to_state on

  state on
    change LED to HIGH
    when BUTTON has_value HIGH go_to_state off

  initial_state off
