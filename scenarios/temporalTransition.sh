#!/bin/bash
DIR=$(dirname "${BASH_SOURCE[0]}")
DIR=$(realpath "${DIR}")

cd ${DIR}/..

cd kernels/jvm
mvn clean install
cd ../..
cd embeddeds/groovy/GroovuinoML
mvn clean install
mvn clean compile assembly:single
java -jar target/dsl-groovy-1.0-jar-with-dependencies.jar scripts/TemporalTransition.groovy
