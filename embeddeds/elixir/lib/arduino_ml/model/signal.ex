defmodule ArduinoML.Signal do

  def enhanced(signal, _) when is_integer(signal) or signal in [:low, :high], do: signal
  def enhanced(signal, application) do
    ArduinoML.Brick.enhanced(signal, application.sensors)
  end
  
  def digital?(:low), do: true
  def digital?(:high), do: true
  def digital?(%{type: type}), do: type == :digital
  def digital?(_), do: false

  def analogic?(%{type: type}), do: type == :analogic
  def analogic?(signal), do: not digital?(signal)

end
