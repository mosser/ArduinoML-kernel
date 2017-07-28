grammar Arduinoml;


/******************
 ** Parser rules **
 ******************/

root        :   bricks EOF;

bricks          :   'sensors' ':' NEWLINE (sensor|actuator)+;
    sensor      :   'sensor'   location NEWLINE;
    actuator    :   'actuator' location NEWLINE;
    location    :   id=IDENTIFIER ':' port=PORT_NUMBER;



/*****************
 ** Lexer rules **
 *****************/

PORT_NUMBER     :   [1-9] | '11' | '12';
IDENTIFIER      :   LOWERCASE (LOWERCASE|UPPERCASE)+;

/*************
 ** Helpers **
 *************/

fragment LOWERCASE  : [a-z]; // abstract rule, does not really exists
fragment UPPERCASE  : [A-Z];
NEWLINE     : ('\r'? '\n' | '\r')+ ;

WS : ((' ' | '\t')+) -> skip; // who cares about whitespaces?
