defmodule ArduinoML.ModelValidator do

  alias ArduinoML.Application, as: Application
  alias ArduinoML.Signal, as: Signal
  
  @doc """
  Validates the given application. If it does not comply, then an exception is raised.
  """
  def validate(application = %Application{}) do
    bricks = application.sensors ++ application.actuators
    
    # Check that all used pins have been associated once and have correct value.
    bricks |> Enum.map(&(&1.pin)) |> validate_used_pins

    # Check that all bricks have a uniq name.
    bricks |> Enum.map(&(&1.label)) |> validate_bricks_names

    # Check the validity of the states and transitions.
    application |> Application.enhanced |> validate_state_machine
    
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

  defp validate_state_machine(%{initial: initial, states: states, transitions: transitions}) do
    if Enum.empty?(states) do
      raise "No state has been declared."
    end

    # Check the initial state existence.
    validate_initial(initial)

    # Check the validity of states and their actions.
    # I did not a Enum.each because I use recursivity to check the uniqueness of states names.
    validate_states(states)

    # Check the validity of transition and their assertions.
    Enum.each(transitions, &(validate_transition(&1)))
    
    :ok
  end

  defp validate_initial(nil), do: raise "There is no initial state."
  defp validate_initial(_), do: :ok

  defp validate_states([]), do: :ok
  defp validate_states([%{label: label, actions: actions} | others]) do
    # Check that the states label is uniq.
    if label in Enum.map(others, &(&1.label)) do
      raise "There cannot be multiple states named '#{label}'."
    end

    # Check that the actions are valid.
    Enum.each(actions, fn action -> validate_action(action) end)

    validate_states(others)
  end

  defp validate_transition(%{from: nil}), do: raise "A transition has an unknown incoming state."
  defp validate_transition(%{to: nil}), do: raise "A transition has an unknown arrival state."
  defp validate_transition(%{on: assertions}) do
    Enum.each(assertions, fn assertion -> validate_assertion(assertion) end)
  end
  
  defp validate_action(%{actuator: nil}), do: raise "An action is bound to an unknown actuator."
  defp validate_action(%{signal: nil}), do: raise "An action has an invalid signal."
  defp validate_action(%{actuator: %{type: type}, signal: signal}) do
    if signal_checker(type).(signal) do
      :ok
    else
      raise "An action has a #{Atom.to_string(type)} actuator and a not-#{Atom.to_string(type)} signal."
    end
  end

  defp validate_assertion(%{sensor: nil}), do: raise "An assertion is bound to an unknown sensor."
  defp validate_assertion(%{signal: nil}), do: raise "An assertion has an unknown signal."
  defp validate_assertion(%{sensor: %{type: type}, signal: signal}) do
    if signal_checker(type).(signal) do
      :ok
    else
      raise "An assertion has a #{Atom.to_string(type)} sensor and a not-#{Atom.to_string(type)} signal."
    end
  end
  
  defp signal_checker(:digital), do: &Signal.digital?/1
  defp signal_checker(:analogic), do: &Signal.analogic?/1
  
end
