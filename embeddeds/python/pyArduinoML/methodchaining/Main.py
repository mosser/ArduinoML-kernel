__author__ = 'pascalpoizat'

"""
DSL version of the demo application
uses MethodChaining, nothing Python-specific
"""


def demo1():
    """
    Direct use of the DSL.
    + : auto-completion (limited due to python typing system)
    - : verbose, Python syntax requires '\' to cut lines.

    :return:
    """
    from pyArduinoML.methodchaining.AppBuilder import AppBuilder
    from pyArduinoML.model.SIGNAL import HIGH, LOW

    app = AppBuilder("Switch!") \
        .sensor("BUTTON").on_pin(9) \
        .actuator("LED").on_pin(12) \
        .state("off") \
            .set("LED").to(LOW) \
            .when("BUTTON").has_value(HIGH).go_to_state("on") \
        .state("on") \
            .set("LED").to(HIGH) \
            .when("BUTTON").has_value(HIGH).go_to_state("off") \
        .get_contents()

    print app

def demo2():
    """
    Use of a wrapper to avoid some python syntax constraints.
    + : simpler syntax
    - : no auto-completion

    :return:
    """
    from pyArduinoML.methodchaining.AppStringBuilder import AppStringBuilder

    app2 = AppStringBuilder("""
    AppBuilder("Switch!")
        .sensor("BUTTON").on_pin(9)
        .actuator("LED").on_pin(12)
        .state("off")
            .set("LED").to(LOW)
            .when("BUTTON").has_value(HIGH).go_to_state("on")
        .state("on")
            .set("LED").to(HIGH)
            .when("BUTTON").has_value(HIGH).go_to_state("off")
    """)

    print app2

if __name__ == '__main__':
    demo1()
    demo2()
