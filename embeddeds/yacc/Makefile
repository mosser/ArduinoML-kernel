#
#  Makefile 	-- Makefile of the ArduinoML written in C
#
# Copyright © 2017 Erick Gallesio - Polytech Nice-Sophia <eg@unice.fr>
#
#           Author: Erick Gallesio [eg@unice.fr]
#    Creation date: 16-Nov-2017 17:42
# Last file update: 28-Nov-2017 09:04 (eg)
#

# Tools
YACC=bison
YFLAGS=  -d 

LEX=flex
LFLAGS=

# C chain
CC=gcc
CFLAGS= -Wall -std=gnu99 -Wno-unused-function -Wextra
LDLIBS=

# Implicit rules
%.c: %.y
	$(YACC) $(YFLAGS) -o $*.c $*.y

%.c: %.l
	$(LEX) $(LFLAGS) -o $*.c $*.l

.PHONY: all clean distclean

# ======================================================================
C   = $(wildcard *.c)
O   = $(C:.c=.o)
EXE = arduinoml
OBJ = arduino_syntax.o arduino_lex.o $(O)

all: $(EXE)


$(EXE): $(OBJ)
	$(CC) $(CFLAGS) -o $(EXE) $(OBJ)

clean:
	/bin/rm -f $(EXE) $(OBJ) arduino_syntax.h

distclean: clean
