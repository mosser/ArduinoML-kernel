Alternatives:

- [pure python, without DSL](#nodsl)

- [DSL using MethodChaining](#methodchaining)
 
## <a name="nodsl">Example in pure python without DSL</a>

```python
from pyArduinoML.model.App import App
from pyArduinoML.model.Action import Action
from pyArduinoML.model.Actuator import Actuator
from pyArduinoML.model.Sensor import Sensor
from pyArduinoML.model.State import State
from pyArduinoML.model.Transition import Transition
from pyArduinoML.model.SIGNAL import HIGH, LOW

button = Sensor("button", 9)
led = Actuator("led", 12)

on = State("on", [Action(HIGH, led)])
off = State("off", [Action(LOW, led)])

switchOn = Transition(button, HIGH, on)
switchOff = Transition(button, LOW, off)

on.setTransition(switchOff)
off.setTransition(switchOn)

app = App("on-off", [button, led], [off, on])

print app
```

In a shell:

1. go to the `embeddeds/python` directory
2. run the python interpreter
 
	```bash
	python
	```
	
3. type:

	```bash
	>>> from pyArduinoML.model.Main import demo
	>>> demo()
	```
	
4. alternatively to 2+3 you can run directly:

	```bash
	python -m pyArduinoML.model.Main
	``

## <a name="methodchaining">Example in python using MethodChaining</a>

