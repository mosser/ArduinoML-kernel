#!/bin/sh
## ================================[ DSshell ]=============================== ##
##
## DSshell is a (very small) framework that helps in defining quickly
## an interesting class of DSL, that is all the DSL whose AST is a
## tree of nodes with types.
##
## We speak of pathes and types.  The type appears in the path, but
## can also be manipulated alone.  For instance, the following path:
##
##     app / Switch! / sensor / BUTTON / pin / 9
##
## has type:
##
##     app / sensor / pin


. Helpers.sh



readonly DSH_BASEDIR=/tmp/DSshell-$(date +%Y%m%d%H%M%S)-$RANDOM
mkdir -p "$DSH_BASEDIR"

readonly MAX_DEPTH_DSL=5

## Debug level
##
## - 0: Critical
## - 1: Error
## - 2: Warning
## - 3: Info
## - 4: Soft debug
## - 5: Violent debug
readonly DSH_DBG_CRITICAL=0
readonly DSH_DBG_ERROR=1
readonly DSH_DBG_WARNING=2
readonly DSH_DBG_INFO=3
readonly DSH_DBG_SOFT=4
readonly DSH_DBG_VIOLENT=5

dsh_debug () { local level=$1; shift; [ "$level" -le "$DSH_DBG_LEVEL" ] && eprintf "$@" || true; }
dsh_debug_critical () { dsh_debug "$DSH_DBG_CRITICAL" "$@"; }
dsh_debug_error    () { dsh_debug "$DSH_DBG_ERROR"    "$@"; }
dsh_debug_warning  () { dsh_debug "$DSH_DBG_WARNING"  "$@"; }
dsh_debug_info     () { dsh_debug "$DSH_DBG_INFO"     "$@"; }
dsh_debug_soft     () { dsh_debug "$DSH_DBG_SOFT"     "$@"; }
dsh_debug_violent  () { dsh_debug "$DSH_DBG_VIOLENT"  "$@"; }

readonly DSH_DBG_LEVEL=$DSH_DBG_INFO



## Let's go!

dsh_get_type_from_path () {
    local path=$1; shift

    printf -- "$path" | cut -d / -f $(seq -s, 1 2 $((MAX_DEPTH_DSL * 2 + 1)))
}

dsh_get_path_prefix_from_type () {
    ## [dsh_get_path_prefix_from_type p t] takes the path [p] and the type
    ## [t] and prints the path [p'] that is a prefix of [p] of type
    ## [t], if it exists.  It prints nothing and returns 1 otherwise.

    local path=$1; shift
    local type=$1; shift

    local path_type=$(dsh_get_type_from_path "$path")

    startswith "$path_type" "$type" || return 1

    local nb_slashes=$(occurrences / "$type")
    printf -- "$path" | cut -d / -f -$((nb_slashes * 2 + 2))
}

dsh_get_value_from_path () {
    ## [dsh_get_value_from_path p] takes the path [p] and returns the
    ## value of the represented node.

    local path=$1; shift

    cut_prefix_greedy "$path" '*/'
}

dsh_get_prefix_value_from_type () {
    ## [dsh_get_prefix_value_from_type p t] takes the path [p] and the
    ## type [t] and returns the value [v] such that there exists a
    ## path [p'] with [p'/v] the prefix of [p] of type [t], if it
    ## exists.  It prints nothing and returns 1 otherwise.

    local path=$1; shift
    local type=$1; shift

    local prefix=
    prefix=$(dsh_get_path_prefix_from_type "$path" "$type") || return 1

    dsh_get_value_from_path "$prefix"
}

dsh_curr=

dsh_elem () {
    local type=$1; shift
    local value=$1; shift

    dsh_debug_info 'dsh_elem: Defining %s "%s"...\n' "$type" "$value"
    dsh_debug_violent 'dsh_elem: dsh_curr = %s\n' "$dsh_curr"

    ## Find the type of this element's ancestor
    local ancestor_type=
    mem / "$type" && ancestor_type=${type%/*}
    type=${type##*/}

    dsh_debug_violent 'dsh_elem: ancestor_type = %s\ndsh_elem: type = %s\n' "$ancestor_type" "$type"

    ## Get the prefix of $dsh_curr that corresponds to the ancestor_type
    local new_dsh_curr=
    if ! new_dsh_curr=$(dsh_get_path_prefix_from_type "$dsh_curr" "$ancestor_type")
    then
	dsh_debug_warning 'dsh_elem: The ancestor type (%s) is not a prefix of the current type!\n' "$ancestor_type"
	return 1
    fi
    dsh_curr=$new_dsh_curr

    dsh_debug_violent 'dsh_elem: dsh_curr = %s\n' "$nb_slashes" "$dsh_curr"

    [ -n "$dsh_curr" ] && dsh_curr="$dsh_curr"/
    dsh_curr="$dsh_curr""$type"/"$value"

    dsh_debug_violent 'dsh_elem: dsh_curr = %s\n' "$dsh_curr"

    ## Add our node under this new $dsh_curr
    mkdir -p "$DSH_BASEDIR"/"$dsh_curr"

    dsh_debug_soft 'dsh_elem: Done (new current = %s).\n' "$dsh_curr"
    dsh_debug_violent '\n'

    ## And continuation! (works thanks to the shifts).  One may not
    ## want that. It's easy to do mistakes with that.  However, it
    ## allows to write stuff like 'when BUTTON has_value HIGH
    ## go_to_state on', because each element takes its first argument
    ## for name, and the rest as an other command.
    "$@"
}

dsh_cleanup () {
    rm -r "$DSH_BASEDIR"
}

dsh_get_children () {
    ## [dsh_get_children p] returns a \n-separated list of children of
    ## the given path.

    local path=$1; shift
    [ -n "$path" ] && path=$path/

    ( cd "$DSH_BASEDIR" && ls -d1 "$path"*/* )
}

dsh_has_type () {
    ## [dsh_has_type p t] takes a path [p] and a type [t] and returns
    ## true whether [p] has type [t] or not.

    local path=$1; shift
    local type=$1; shift
    
    [ "$(dsh_get_type_from_path "$path")" == "$type" ]
}

dsh_filter_with_type () {
    ## [dsh_filter_with_type t] takes a type [t] and an input flow
    ## representing a \n-separated list of pathes and produces an
    ## output flow representing a \n-separated list of pathes that all
    ## have the type [t].
    
    local type=$1; shift
    local path=
    
    while read path
    do
	if dsh_has_type "$path" "$type"
	then
	    printf -- "$path\n"
	fi
    done
}

dsh_get_children_of_type () {
    ## [dsh_get_children_of_type p t] takes a path [p] and a type [t]
    ## and returns all the children of [p] that have type [t].

    local path=$1; shift
    local type=$1; shift
    
    dsh_get_children "$path" | dsh_filter_with_type "$type"
}

dsh_get_child_of_type () {
    ## [dsh_get_child_of_type p t] takes a path [p] and a type [t] and
    ## returns one child of [p].  If there are many children, the
    ## result is not specified.

    local path=$1; shift
    local type=$1; shift

    dsh_get_children_of_type "$path" "$type" | head -n 1
}

dsh_get_descendants () {
    ## [dsh_get_descendants p] takes a path and returns all its
    ## descendants.

    local path=$1; shift
    [ -n "$path" ] && path=$path/

    local path_descendant=
    
    ( cd "$DSH_BASEDIR" && find "$path"* ) | \
	while read path_descendant
	do
	    if odd "$(occurrences / "$path_descendant")"
	    then
		printf -- "$path_descendant\n"
	    fi
	done
}

dsh_get_descendants_of_type () {
    ## [dsh_get_descendants_of_type p t] takes a path [p] and a type
    ## [t] and returns all the children of [p] that have type [t].

    local path=$1; shift
    local type=$1; shift

    dsh_get_descendants "$path" | dsh_filter_with_type "$type"
}

dsh_get_from_type () {
    ## dsh_get_from_type takes a type and, optionally a value and
    ## returns all the elements that have the given type under the
    ## specified value.

    local type=$1
    local regex=$(printf -- "$type" | sed 's|/|/[^/]*/|g')/[^/]*

    dsh_debug_violent 'dsh_get_from_type: regex = %s\n' "$regex"

    local prefix=$2
    [ -n "$prefix" ] && prefix=$prefix/

    ( cd "$DSH_BASEDIR" && find "$prefix"* -regex "$regex" )
}
