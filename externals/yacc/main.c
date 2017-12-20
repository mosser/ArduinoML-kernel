/*
 * main.c       -- main file for ArduinoML
 *
 *           Author: Erick Gallesio [eg@unice.fr]
 *    Creation date: 17-Nov-2017 11:44
 * Last file update: 17-Nov-2017 12:10 (eg)
 */

#include <stdio.h>
#include <stdlib.h>
#include "arduino.h"

// Bison/Yacc objects
extern FILE *yyin;
extern int yyparse();



int main(int argc, char* argv[]) {
  yyin = stdin;
  if (argc == 2) {
    input_path = argv[1];
    if ((yyin = fopen(input_path, "r")) == NULL) {
      fprintf(stderr, "%s: cannot open input file '%s'\n", *argv, input_path);
      exit(1);
    }
  }
  return yyparse();
}
