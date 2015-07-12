__author__ = 'pascalpoizat'

"""
Enumeration of signal values.
"""

LOW = 0
HIGH = 1

def value(signal):
    """
    Returns the string representation of a signal.

    :param signal: Signal, the signal
    :return: String, the representation of the signal in the Arduino language
    """
    if signal == LOW:
        return "LOW"
    if signal == HIGH:
        return "HIGH"
    return ""