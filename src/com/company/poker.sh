#!/bin/bash

clear
set -ae

function finish {
  echo "Please press any key to continue."
    read -n 1 -s
}
trap finish EXIT

javac *.java
java  Main

#chmod 777 *.class
done 