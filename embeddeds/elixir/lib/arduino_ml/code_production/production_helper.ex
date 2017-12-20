defmodule ArduinoML.ProductionHelper do

  @doc """
  Returns a C inline commentary.
  """
  def comment(content) do
    "// " <> content <> "\n"
  end

  @doc """
  Returns the content with the asked indentation.
  """
  def indented(content, level) do
    String.duplicate("  ", level) <> content
  end

  @doc """
  Returns a string wich is formatted as a C statement.
  """
  def statement(content) do
    content <> ";\n"
  end

  @doc """
  Returns a new line.
  """
  def new_line, do: "\n"
end
