# ArduinoML-kernel in Idris

[Idris] is a dependly-typed programming language
initially developped by [Edwin Brady].

An interesting feature of the language is the ability to define
quickly an [embedded DSL syntax](eDslInIdris).

# Idris setup

- [Install Idris](https://www.idris-lang.org/download/)
- [Development environement](https://github.com/idris-lang/Idris-dev/wiki/Editors)
- [Language documentation](http://docs.idris-lang.org/en/latest/tutorial/index.html)

# Package installation

The language does not have yet a very developped ecosystem yet.
As a consequence, package management is primitive and you have
to install dependencies on your own.

Hopefully, this project only requires one, that should be install form github:

```
$ git clone https://github.com/berewt/UnionType.git
$ cd UnionType
$ idris --install union_type.ipkg
```

Then, you can install the `arduinoml` package in a similar way,
go in the directory of this readme and then do:

```
$ idris -p union_type --install arduinoml.ipkg
```

# Testing

You can then play with the library, open a REPL with the arduinoml package loaded:

```
$ idris -p arduinoml
```

Then load the a model and transform it, you can use the [sample] from the `examples` directory:

```
$ idris> :l examples/Switch.idr
$ idris> appToWire switchApp
```



[Idris](https://www.idris-lang.org)
[sample](./examples/Switch.idr)
[Edwin Brady](https://github.com/edwinb)
[eDslInIdris](http://docs.idris-lang.org/en/latest/tutorial/syntax.html)

