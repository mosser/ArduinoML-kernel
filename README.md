# ArduinoML

  * Author: [Sébastien Mosser](mailto:mosser@i3s.unice.fr?subject=ArduinoML) 
  * Version: 1.0
  
This repository is a zoo of implementation of the very same language: ArduinoML. This language is kept simple and naive by essence, the goal of this repository is to store at the same location several implementations of the same concepts. 

The idea of this zoo raise after the DSL course I made at [EJCP'15](http://ejcp2015.inria.fr/) and [JDEV'15](http://devlog.cnrs.fr/jdev2015) during June 2015. It is also used as a support for the _DSL Engineering_ course running at [Polytech'Nice](http://informatique.polytechnice.fr).

This repository is a community-based effort. Contributions for each implementations were made by their respective authors (see the readme file of each implementation for details).

## Domain Description

ArduinoML is an example of a _Domain Specific Language_ (DSL), designed to model simple application executed on top of Arduino boards. It is specific to this class of applications, _i.e._, allowing anyone to model simple pieces of software that bind sensors to actuators. 

For example, let’s consider the following scenario: _“As a user, considering a button and a LED, I want to switch on the LED after pushing the button. Pushing the button again will switch it off, and so on”_. The essence of ArduinoML is to support the definition of such an application. 


![](https://raw.githubusercontent.com/mosser/ArduinoML-kernel/master/docs/platform_small.png)

## Repository Organization

  * `docs` contains the documentation that exists on ArduinoML (basically a description of the kernel)
  * `kernels` contains models and implementations of the abstract syntax of the language.
  * `embeddeds` defines several alternative implementations of ArduinoML, embedded in host languages 
  * `externals` defines several alternative implenentations of ArduinoML, as external langauges.

## Contributors

  * [Nicolas Biri](https://www.linkedin.com/profile/view?id=91979)
    * Haskell
  * [Nicolas Jeannerod](https://niols.fr/)
    * Shell
  * [Ivan Logre](http://www.i3s.unice.fr/~logre/)
    * Xtext
  * [Thomas Moreau](https://www.linkedin.com/in/moreaut/?ppe=1)
    * Groovy
  * [Sébastien Mosser](http://www.i3s.unice.fr/~mosser)
    * Zoo architect
  * [Pascal Poizat](https://pages.lip6.fr/Pascal.Poizat/)
    * Python
  * [Serge Stinckwich](http://www.doesnotunderstand.org/)
    * Pharo
  * [Erick Gallesio](http://gallesio.org/~eg)
    * Lex/Yacc/C
    * Scheme
  * [Antoine Aubé](https://github.com/AntoineAube)
    * Elixir
  * [Julien Deantoni](https://webusers.i3s.unice.fr/~deantoni/)
    * Langium, Xtext v2
## References

  * [2014] Sébastien Mosser, Philippe Collet, Mireille Blay-Fornarino. _“Exploiting the Internet of Things to Teach Domain-Specific Languages and Modeling”_ in Proceedings of the 10th Educators' Symposium @ MODELS 2014 (EduSymp'14), ACM, IEEE, pages 1-10, Springer LNCS, Valencia, Spain, 29 september 2014
    * [Article](http://www.i3s.unice.fr/~mosser/_media/research/edusymp14.pdf), [Slides](http://www.i3s.unice.fr/~mosser/_media/research/edusymp14_slides.pdf)
