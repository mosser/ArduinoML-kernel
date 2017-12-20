;;
;; A simple example in ArduinoML for Scheme
;;
(define-application Simple
  :sensors
  ((button 9))
  :actuators
  ((led1 11)
   (led2 12))
  :states
  ((on  (set! led  "HIGH")
        (set! Led2 "LOW"))
   (off (set! led3 "LOW")
        (set! led4 "HIGH")))
  :transitions
  ((on -> off  when button2 "HIGH")
   (off -> ON  when button "HIGH"))
  :initial
  off)

