#!/bin/sh
set -e

PATH=.:$PATH . DSshell.sh

app           () { dsh_elem app                        "$@"; }

sensor        () { dsh_elem app/sensor                 "$@"; }
actuator      () { dsh_elem app/actuator               "$@"; }
state         () { dsh_elem app/state                  "$@"; }
initial_state () { dsh_elem app/initial_state          "$@"; }
		   
pin           () {
    if ! dsh_elem app/sensor/pin "$@"
    then
	dsh_debug_info 'Could not define ping under app/sensor. Trying under app/actuator.\n'
	dsh_elem app/actuator/pin "$@"
    fi
}
change        () { dsh_elem app/state/change           "$@"; }
when          () { dsh_elem app/state/when             "$@"; }

to            () { dsh_elem app/state/change/to        "$@"; }
has_value     () { dsh_elem app/state/when/has_value   "$@"; }
go_to_state   () { dsh_elem app/state/when/go_to_state "$@"; }

. Switch.sh

## for each app
dsh_get_children_of_type '' app | \
    while read app
    do
	app_value=$(dsh_get_value_from_path "$app")

 	printf '// This file has been generator by ArduinoML.sh\n\n'

	printf 'long time = 0;\nlong debounce = 200;\n\n'
	
	## foreach app >> pin : app/sensor/pin
	dsh_get_descendants_of_type "$app" app/sensor/pin | \
	    while read pin
	    do
		sensor_value=$(dsh_get_prefix_value_from_type "$pin" app/sensor)
		pin_value=$(dsh_get_value_from_path "$pin")
		
	    	printf 'int sensor_%s = %d;\n' "$sensor_value" "$pin_value"
	    done

	## foreach app >> pin : app/actuator/pin
	dsh_get_descendants_of_type "$app" app/actuator/pin | \
	    while read pin
	    do
		actuator_value=$(dsh_get_prefix_value_from_type "$pin" app/actuator)
		pin_value=$(dsh_get_value_from_path "$pin")
		
	    	printf 'int actuator_%s = %d;\n' "$actuator_value" "$pin_value"
	    done

 	printf '\nvoid setup () {\n'

	## foreach app >> pin : app/sensor/pin
	dsh_get_descendants_of_type "$app" app/sensor/pin | \
	    while read pin
	    do
		sensor_value=$(dsh_get_prefix_value_from_type "$pin" app/sensor)

		printf '  pinMode(sensor_%s, INPUT);\n' "$sensor_value";
	    done

	## foreach app >> pin : app/actuator/pin
	dsh_get_descendants_of_type "$app" app/actuator/pin | \
	    while read pin
	    do
		actuator_value=$(dsh_get_prefix_value_from_type "$pin" app/actuator)
		
	    	printf '  pinMode(sensor_%s, OUTPUT);\n' "$actuator_value"
	    done

	printf '}\n' ## end setup

	## foreach app > state : app/state
	dsh_get_children_of_type "$app" app/state | \
	    while read state
	    do
		state_value=$(dsh_get_value_from_path "$state")

		printf '\nvoid state_%s () {\n' "$state_value"

		## foreach state >> to : app/state/change/to
		dsh_get_descendants_of_type "$state" app/state/change/to | \
		    while read to
		    do
			to_value=$(dsh_get_value_from_path "$to")
			change_value=$(dsh_get_prefix_value_from_type "$to" app/state/change)			

			printf '  digitalWrite(%s, %s);\n' "$state_value" "$to_value"
		    done

		## foreach state > when : app/state/when
		dsh_get_children_of_type "$state" app/state/when | \
		    while read when
		    do
			when_value=$(dsh_get_value_from_path "$when")
			hasvalue_value=$(dsh_get_value_from_path "$(dsh_get_child_of_type "$when" app/state/when/has_value)")
			gotostate_value=$(dsh_get_value_from_path "$(dsh_get_child_of_type "$when" app/state/when/go_to_state)")

			printf '  if ((digitalRead(%s) == %s) && (millis() - time > debounce)) {\n' "$when_value" "$hasvalue_value"
			printf '    time = millis();\n'
			printf '    state_%s();\n' "$gotostate_value"
			printf '    return;\n'
			printf '  }\n'
		    done

		printf '  state_%s();\n' "$state_value"
		printf '}\n'
	    done

	initialstate_value=$(dsh_get_value_from_path "$(dsh_get_child_of_type "$app" app/initial_state)")
	printf '\nvoid loop() { state_%s(); }\n' "$initialstate_value"
    done

dsh_cleanup
