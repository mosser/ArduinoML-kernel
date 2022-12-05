#!/bin/sh

printf "[[ MAGIC RUN.SH ]]\n"

JAVA_VER=$(java -version 2>&1 | sed -n ';s/.* version "\(.*\)\.\(.*\)\..*".*/\1\2/p;' | head -n 1)

if [ -z "$JAVA_VER" ]; then
  echo "Java is not installed!"
  exit 1
fi

# JAVA_VER=$((JAVA_VER - 0))

# if [ "$JAVA_VER" -lt 170 ]; then
#   echo "Java version is too low, please install Java 17 or higher!"
#   exit 1
# fi

EMBEDDED_PATH=$(find . -name "*.jar" -not -path "./gradle/*" | head -n 1)

if [ -d ~/.m2/repository ]; then
  KERNEL_PATH=$(find ~/.m2/repository -name "kernel-jvm*.jar" | head -n 1)
fi

while [ "$#" -gt 0 ]; do
  case "$1" in
  -p | --package)
    EMBEDDED_PATH="$2"
    shift 2
    ;;
  -h | --help)
    echo "Usage: $0 [-p|--package <path to dsl-groovy-all.jar>] <path to the Groovy script file>]"
    exit 0
    ;;
  *)
    SCRIPT_PATH="$1"
    break
    ;;
  esac
done

HAS_KERNEL=false
HAS_EMBEDDED=false

if [ -n "$EMBEDDED_PATH" ]; then
  if [ -f "$EMBEDDED_PATH" ]; then
    HAS_EMBEDDED=true
  else
    echo "Provided DSL package path (-p) does not exist!"
    exit 1
  fi
fi

if [ -n "$KERNEL_PATH" ]; then
  if [ -f "$KERNEL_PATH" ]; then
    HAS_KERNEL=true
  else
    echo "Provided kernel package path (-k) does not exist!"
    exit 1
  fi
fi

if [ "$HAS_KERNEL" = false ] || [ "$HAS_EMBEDDED" = false ]; then
  CWD=$(pwd)
  if [ "$HAS_KERNEL" = false ]; then
    echo "Kernel not found, building it..."
    cd ../../kernels/jvm || exit
    mvn install >/dev/null
    cd "$CWD" >/dev/null || exit
    KERNEL_PATH=$(find ~/.m2/repository -name "kernel-jvm*.jar" | head -n 1)

    if [ "$HAS_EMBEDDED" = true ]; then
      rm -rf build
      echo "Removing DSL package build directory since kernel is newer..."
      HAS_EMBEDDED=false
    fi
  fi

  if [ "$HAS_EMBEDDED" = false ]; then
    echo "Embedded DSL package not found, building it..."
    ./gradlew shadowJar >/dev/null
    EMBEDDED_PATH=$(find . -name "*.jar" -not -path "./gradle/*" | head -n 1)
  fi
fi

if [ -z "$EMBEDDED_PATH" ]; then
  echo "Build failed, please build the project through build.sh to debug errors"
  exit 1
fi


if [ -z "$SCRIPT_PATH" ]; then
  echo "Usage: $0 [-p|--package <path to dsl-groovy-all.jar>] <path to the Groovy script file>]"
  printf "No script path provided. "

  if [ -f "scripts/Switch.groovy" ]; then
    printf 'Run with the default scripts/Switch.groovy? [y/n]: '
    read -r answer
    if [ "$answer" != "y" ]; then
      exit 1
    fi
    SCRIPT_PATH=scripts/Switch.groovy
  else
    printf "No example script found, exiting."
    exit 1
  fi

fi

FILE_NAME=$(basename "$SCRIPT_PATH") && FILE_NAME="${FILE_NAME%.*}"
echo "// Generated using run.sh with $(basename "$SCRIPT_PATH") by $(basename "$EMBEDDED_PATH") on $(date)" >"${FILE_NAME}.ino"
java -jar "$EMBEDDED_PATH" "$SCRIPT_PATH" >>"${FILE_NAME}.ino"
echo "Exported ${FILE_NAME}.ino successfully!"