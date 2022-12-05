#!/bin/sh

CWD=$(pwd)
cd ../../kernels/jvm || exit
mvn install
cd "$CWD" || exit
./gradlew shadowJar