;;
;; A simple example in ArduinoML for Scheme
;;
(define-application Example_with_two_leds
  :sensors
  ((button 9))
  :actuators
  ((led1 11)
   (led2 12))
  :states
  ((on  (set! led1 "HIGH") (set! led2 "LOW"))
   (off (set! led1 "LOW")  (set! led2 "HIGH")))
  :transitions
  ((on -> off when button "HIGH")
   (off -> on when button "HIGH"))
  :initial
  off)

