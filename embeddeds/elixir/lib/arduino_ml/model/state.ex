defmodule ArduinoML.State do
  defstruct label: nil, actions: []

  def enhanced(nil, _), do: nil
  def enhanced(%{label: label, actions: actions}, application) do
    enhanced_actions = Enum.map(actions, fn action -> ArduinoML.Action.enhanced(action, application) end)

    %ArduinoML.State{label: label, actions: enhanced_actions}
  end
  def enhanced(state_label, application) do
    enhanced(Enum.find(application.states, fn %{label: label} -> state_label == label end), application)
  end
    
end
