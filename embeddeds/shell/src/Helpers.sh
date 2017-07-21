#!/bin/sh

eprintf () { printf "$@" >&2; }
die () { eprintf "$@"; exit 2; }

## [startswith haystack needle] returns true whether [needle] is a
## prefix from [haystack] or not.
startswith () { [ "$2${1#$2}" == "$1" ]; }

## [occurrences char haystack] returns the number of occurrences of
## [char] in [haystack].
occurrences () { local chars=$(printf -- "$2" | tr -dC "$1"); printf -- "${#chars}"; }

## [mem char haystack] returns true whether [char] occurs in
## [haystack] or not.
mem () { [ "$(occurrences "$@")" -gt 0 ]; }

## [cut_prefix haystack prefix] returns [haystack] without the prefix
## matching [prefix].  [cut_prefix_greedy] is the greedy version.
## [cut_suffix] and [cut_suffix_greedy are similar].
cut_prefix () { printf -- "${1#$2}"; }
cut_prefix_greedy () { printf -- "${1##$2}"; }
cut_suffix () { printf -- "${1%$2}"; }
cut_suffix_greedy () { printf -- "${1%%$2}"; }

## [ignore cmd...] runs the command [cmd] and ignores the errors.  It
## does not stop the [exit] exception.
ignore () { if "$@"; then true; else true; fi; }

## [mute cmd...] runs the command [cmd] and hides both its standard
## output and error output.
mute () { "$@" >/dev/null 2>&1; }

even () { [ "$(( $1 % 2 ))" -eq 0 ]; }
odd () { ! even "$1"; }
