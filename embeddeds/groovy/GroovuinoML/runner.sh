#!/usr/bin/env bash

BASEDIR=$(dirname $0)
DIR=$(dirname "${BASH_SOURCE[0]}")
DIR=$(realpath "${DIR}")

echo ${DIR}
cd ${BASEDIR}/../../../kernels/jvm
mvn clean install
cd ${DIR}

mvn clean compile assembly:single
# java -jar ./target/dsl-1.0-jar-with-dependencies.jar scripts/helloworld.groovy
echo 'executing scenario ' $1
java -jar ./target/dsl-groovy-1.0-jar-with-dependencies.jar ./scripts/$1'.groovy'
