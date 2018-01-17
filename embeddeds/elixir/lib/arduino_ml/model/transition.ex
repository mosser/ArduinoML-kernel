defmodule ArduinoML.Transition do
  defstruct from: nil, to: nil, on: []

  def enhanced(%{from: from_label, to: to_label, on: assertions}, application) do
    from = ArduinoML.State.enhanced(from_label, application)
    to = ArduinoML.State.enhanced(to_label, application)

    enhanced_assertions = Enum.map(assertions,
      fn assertion -> ArduinoML.Assertion.enhanced(assertion, application) end)

    %ArduinoML.Transition{from: from, to: to, on: enhanced_assertions}
  end
  
end
