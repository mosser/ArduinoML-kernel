defmodule ArduinoML.ModelValidator do

  alias ArduinoML.Application, as: Application

  @doc """
  Validates the given application. If it does not comply, then an exception is raised.
  """
  def validate(app = %Application{}) do
    bricks = app.sensors ++ app.actuators
    
    # Check that all used pins have been associated once and have correct value.
    bricks |> Enum.map(&(&1.pin)) |> validate_used_pins

    # Check that all bricks have a uniq name.
    bricks |> Enum.map(&(&1.label)) |> validate_bricks_names

    # Check the validity of the states and transitions.
    validate_state_machine(app)
    
    # If it survived, then return OK!
    :ok
  end

  defp validate_used_pins([]), do: :ok
  defp validate_used_pins([pin | others]) when is_integer(pin) do
    if pin in others do
      raise "The pin #{Integer.to_string(pin)} has been bound more than once."
    end

    unless pin in 1..17 do
      raise "Pins must be included between 1 and 17 (found: #{Integer.to_string(pin)})."
    end

    validate_used_pins(others)
  end

  defp validate_bricks_names([]), do: :ok
  defp validate_bricks_names([label | others]) do
    if label in others do
      raise "The brick label #{Atom.to_string(label)} has been declared more than once."
    end
  end

  defp validate_state_machine(%{initial: initial, states: states, transitions: transitions, actuators: actuators, sensors: sensors}) do
    if Enum.empty?(states) do
      raise "No state has been declared."
    end

    # Check the initial state existence.
    validate_initial(initial, states)

    # Check the validity of states and their actions.
    validate_states(states, Enum.map(actuators, &(&1.label)))

    # Check the validity of transition and their assertions.
    validate_transitions(transitions, Enum.map(sensors, &(&1.label)), Enum.map(states, &(&1.label)))
    
    :ok
  end

  defp validate_initial(nil, _), do: :ok
  defp validate_initial(initial, states) do
    if not initial in Enum.map(states, &(&1.label)) do
      raise "The specified initial state is not an existing state."
    end

    :ok
  end

  defp validate_states([], _), do: :ok
  defp validate_states([%{label: label, actions: actions} | others], actuators_labels) do
    # Check that the states label is uniq.
    if label in Enum.map(others, &(&1.label)) do
      raise "There cannot be multiple states named '#{label}'."
    end

    # Check that the actions are valid.
    Enum.each(actions, fn action -> validate_action(action, actuators_labels) end)

    validate_states(others, actuators_labels)
  end

  defp validate_action(%{actuator_label: actuator_label, signal: signal}, actuators_labels) do
    if not actuator_label in actuators_labels do
      raise "An action used an unknown actuator (named: #{actuator_label})."
    end

    if not signal in [:low, :high] do
      raise "A signal must be either :low or :high (not: #{signal})."
    end

    :ok
  end

  defp validate_transitions([], _, _), do: :ok
  defp validate_transitions([%{from: from, to: to, on: assertions} | others], sensors_labels, states_labels) do
    # Check that :from is known
    if not from in states_labels do
      raise "No transition can come from the unknown state '#{from}'."
    end

    if not to in states_labels do
      raise "No transition can go to the unknown state '#{to}'."
    end

    Enum.each(assertions, fn assertion -> validate_assertion(assertion, sensors_labels) end)

    validate_transitions(others, sensors_labels, states_labels)
  end

  defp validate_assertion(%{sensor_label: sensor_label, signal: signal}, sensors_labels) do
    if not sensor_label in sensors_labels do
      raise "An assertion used an unknown sensor (named: #{sensor_label})."
    end

    if not signal in [:low, :high] do
      raise "A signal must be either :low or :high (not: #{signal})."
    end

    :ok
  end
  
end
