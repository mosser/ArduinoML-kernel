#
#  Makefile 	--
#
# Copyright © 2017 Erick Gallesio - Polytech Nice-Sophia <eg@unice.fr>
#
#           Author: Erick Gallesio [eg@unice.fr]
#    Creation date:  4-Dec-2017 16:34
# Last file update:  4-Dec-2017 18:13 (eg)
#

SUCCESS=$(wildcard Examples/example*.scm)
FAIL=$(wildcard Examples/fail*.scm)

.PHONY: all clean distclean

all:
	mkdir -p OUT
	bin/test-execution $(SUCCESS) $(FAIL)

clean:
	rm -rf *~ OUT

distclean: clean
