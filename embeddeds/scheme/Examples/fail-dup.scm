;;
;; A simple example in ArduinoML for Scheme
;;
(define-application Simple
  :sensors
  ((button 9))
  :actuators
  ((led 9)               ;; port already used
   (button 10))          ;; name already used
  :states
  ((on  (set! led "HIGH"))
   (off (set! led "LOW")))
  :transitions
  ((on -> off when button "HIGH")
   (off -> on when button "HIGH"))
  :initial
  off)
  


