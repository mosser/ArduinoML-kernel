defmodule ArduinoMlTest do
  use ExUnit.Case
  doctest ArduinoMl

  test "greets the world" do
    assert ArduinoMl.hello() == :world
  end
end
