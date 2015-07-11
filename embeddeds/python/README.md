Alternatives:

- [pure python, without DSL](#nodsl) for reference

- [DSL using MethodChaining](#methodchaining)
 
## <a name="nodsl">Example in pure python without DSL</a>

```python
[... imports ...]

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
2. run the python interpreter, `python`, and type:


	```bash
	>>> from pyArduinoML.model.Main import demo
	>>> demo()
	```
	
3. alternatively to 2 you can run directly:

	```bash
	python -m pyArduinoML.model.Main
	```

## <a name="methodchaining">Example in python using MethodChaining</a>

