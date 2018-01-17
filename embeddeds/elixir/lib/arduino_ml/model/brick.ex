defmodule ArduinoML.Brick do
  defstruct label: nil, pin: nil, type: :digital

  def enhanced(label, bricks) do
    Enum.find(bricks, fn %{label: brick_label} -> brick_label == label end)
  end
  
end

