import dsl.GroovuinoMLDSL

/**
 * This main takes one argument: the path to the Groovy script file to execute.
 * This Groovy script file must follow GroovuinoML DSL's rules.
 *
 * "We've Got A Groovy Thing Goin'"!
 *
 * @author Thomas Moreau
 */
class GroovuinoML {
    static void main(String[] args) {
        GroovuinoMLDSL dsl = new GroovuinoMLDSL()
        if (args.length > 0) {
            dsl.eval(new File(args[0]))
        } else {
            println "Usage: groovy GroovuinoML.groovy <path to Groovy script file>"
        }
    }
}
