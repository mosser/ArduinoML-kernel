defmodule ArduinoML.Assertion do
  defstruct sensor: nil, signal: nil, comparison: nil

  def enhanced(%{sensor: sensor_label, signal: signal_label, comparison: comparison}, application) do
    sensor = ArduinoML.Brick.enhanced(sensor_label, application.sensors)
    signal = ArduinoML.Signal.enhanced(signal_label, application)

    %ArduinoML.Assertion{sensor: sensor, signal: signal, comparison: comparison}
  end
  
end
