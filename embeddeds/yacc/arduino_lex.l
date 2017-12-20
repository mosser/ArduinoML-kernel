%{
   #include "arduino_syntax.h"

%}
%option noyywrap
%option yylineno

%%
  /* ==== Keywords ==== */
"application"           return KAPPL;
"sensor"                return KSENSOR;
"actuator"              return KACTUATOR;
"is"                    return KIS;
"HIGH"                  return KHIGH;
"LOW"                   return KLOW;
"=>"                    return RIGHT;
"<="                    return LEFT;
"->"                    return INITSTATE;


  /* ==== port numbers (as strings) and identifiers */
[1-9]|(1[012])          { yylval.value = atoi(yytext); return PORT_NUMBER; }
[a-zA-Z][a-zA-Z0-9_]+   { yylval.name  = strdup(yytext); return IDENT; }

  /* ==== Spaces and comments ==== */
[ \t\n]                 { }
"//".*                  { }

 /* ==== Default ==== */
.                       return *yytext;

