__author__ = 'pascalpoizat'

"""
DSL version of the demo application
uses MethodChaining, nothing Python-specific
"""


def demo1():
    from pyArduinoML.methodchaining.AppBuilder import AppBuilder
    from pyArduinoML.model.SIGNAL import HIGH, LOW

    app = AppBuilder("on-off") \
        .sensor("button").on_pin(9) \
        .actuator("led").on_pin(12) \
        .state("off") \
            .set("led").to(LOW) \
            .when("button").has_value(HIGH).go_to_state("on") \
        .state("on") \
            .set("led").to(HIGH) \
            .when("button").has_value(LOW).go_to_state("off") \
        .get_contents()

    print app

def demo2():
    from pyArduinoML.methodchaining.AppStringBuilder import AppStringBuilder

    app2 = AppStringBuilder("""
    AppBuilder("on-off")
        .sensor("button").on_pin(9)
        .actuator("led").on_pin(12)
        .state("off")
            .set("led").to(LOW)
            .when("button").has_value(HIGH).go_to_state("on")
        .state("on")
            .set("led").to(HIGH)
            .when("button").has_value(LOW).go_to_state("off")
    """)

    print app2

if __name__ == '__main__':
    demo1()
    demo2()
