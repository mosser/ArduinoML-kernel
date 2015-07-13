package io.github.mosser.arduinoml.dsl

import io.github.mosser.arduinoml.kernel.App
import io.github.mosser.arduinoml.kernel.generator.ToWiring
import io.github.mosser.arduinoml.kernel.structural._
import io.github.mosser.arduinoml.kernel.behavioral._
import collection.JavaConversions._

/**
 * Quick and dirty implementation of ArduinoML as an embedded DSL for Scala
 */
trait ArduinoML {

  /*************************************************
   ** Protected methods available as embedded DSL **
   *************************************************/

  // Set the name of the App
  protected def hasForName(n: String) { app.setName(n) }

  // Declaration of a Brick
  protected def declare: StructureBuilder = {
    flush()
    currentBrick = Some(StructureBuilder())
    currentBrick.get
  }

  // Declaration of a state
  protected def state: StateBuilder = {
    flush()
    currentState = Some(StateBuilder())
    currentState.get
  }

  // Declaration of the transition system
  protected def transitions(transitionSystem: => Unit) {
    flush()
    transitionSystem
  }

  // Trigger a visit of the app under construction to generate the Wiring code
  protected def exportToWiring = {
    flush()
    val codeGen = new ToWiring()
    app.accept(codeGen)
    println(codeGen.getResult)
  }

  /*********************
   ** Private Helpers **
   *********************/

  // The app to be built when this trait is mixed in an object
  private[this] val app: App = {
    val tmp = new App()
    tmp.setBricks(List[Brick]())
    tmp.setStates(List[State]())
    tmp
  }

  // Flush the elements under construction into the App, if any
  private def flush() {
    if (currentBrick.isDefined) {
      app.setBricks(app.getBricks :+ currentBrick.get.toBrick)
      currentBrick = None
    }
    if (currentState.isDefined) {
      app.setStates(app.getStates :+ currentState.get.toState)
      currentState = None
    }
  }

  // The Brick under construction, if any
  private var currentBrick: Option[StructureBuilder] = None

  // The State under construction, if any
  private var currentState: Option[StateBuilder] = None

  // A method to find a brick based on its name  (assumed unique)
  private def getBrickByName(n: String): Brick = {
    (app.getBricks find( _.getName == n )).get
  }

  // a method to find a state based on its name (assumed unique)
  private def getStateByName(n: String): State = {
    (app.getStates find( _.getName == n )).get
  }

  /*************************************************************
   ** Protected Data structures used to drive method chaining **
   *************************************************************/

  // Kind of brick on can create using ArduinoML
  protected object Bricks extends Enumeration {
    val UNKNOWN, SENSOR, ACTUATOR = Value
  }

  // Builder to support Brick construction
  protected case class StructureBuilder(kind: Bricks.Value = Bricks.UNKNOWN, pin: Int = -1, name: String = "") {

    // Build a sensor
    def aSensor(): StructureBuilder = {
      currentBrick = Some(this.copy(kind = Bricks.SENSOR))
      currentBrick.get
    }

    // Build an actuator
    def anActuator(): StructureBuilder = {
      currentBrick = Some(this.copy(kind = Bricks.ACTUATOR))
      currentBrick.get
    }

    // Set the pin associated to the brick
    def boundToPin(p: Int): StructureBuilder = {
      currentBrick = Some(this.copy(pin = p))
      currentBrick.get
    }

    // set the name of the brick
    def named(n: String): StructureBuilder = {
      currentBrick = Some(this.copy(name = n))
      currentBrick.get
    }

    // Helper method used to transform a builder into a Brick
    def toBrick: Brick = {
      val brick = currentBrick.get.kind match {
        case Bricks.SENSOR   => new Sensor()
        case Bricks.ACTUATOR => new Actuator()
        case _ => throw new UnsupportedOperationException("Undefined brick type")
      }
      brick.setName(currentBrick.get.name)
      brick.setPin(currentBrick.get.pin)
      brick
    }

    // Operator used to bind a brick to a signal when building an Action
    def -->(signal: Signal): ActionBuilder = ActionBuilder(this,signal)

    // operator used to bind a brick to a signal when building a Transition
    def is(signal: Signal): ConditionBuilder = ConditionBuilder(this, signal)
  }
  
  // Builder to support State construction
  protected case class StateBuilder(name: String = "", actions: Seq[Action] = Seq()) {

    // Set the name of the state
    def named(n: String): StateBuilder = {
      currentState = Some(this.copy(name = n))
      currentState.get 
    }

    // declare the sequence of actions (comma separated) to be performed when entering this state
    def executing(actions: ActionBuilder*): StateBuilder = {
      val acts = actions map { b => 
        val a = new Action()
        a.setActuator(getBrickByName(b.actuator.name).asInstanceOf[Actuator])
        a.setValue(b.signal.asSignal)
        a
      }
      currentState = Some(this.copy(actions = acts))
      currentState.get
    }

    // Set the initial state of the app
    def isInitial: Unit = {
      flush()
      app.setInitial(getStateByName(this.name))
    }

    // transform a builder into a concrete state
    def toState: State = {
      val s = new State()
      s.setName(this.name)
      s.setActions(this.actions)
      s
    }

    // operator to bind a state to another one when building a transition
    def ->(next: StateBuilder): TransitionBuilder = TransitionBuilder(this,next)
  }

  // Builder to support Action construction
  protected case class ActionBuilder(actuator: StructureBuilder, signal: Signal)

  // Builder to support Condition construction (in Transition)
  protected case class ConditionBuilder(sensor: StructureBuilder, signal: Signal)

  // Builder to support Transition construction
  protected case class TransitionBuilder(from: StateBuilder, to: StateBuilder) {
    // Method to bind a transition to its condition. By side-effect it stores the transition in app
    def when(cond: ConditionBuilder): Unit = {
      val trans = new Transition()
      trans.setNext(getStateByName(to.name))
      trans.setSensor(getBrickByName(cond.sensor.name).asInstanceOf[Sensor])
      trans.setValue(cond.signal.asSignal)
      getStateByName(from.name).setTransition(trans)
    }
  }

  // syntactic sugar on top of kernel SIGNALs
  trait Signal { val asSignal: SIGNAL }
  object high extends Signal { override val asSignal = SIGNAL.HIGH }
  object low  extends Signal { override val asSignal = SIGNAL.LOW }
}
