#!/bin/bash

clear

function finish {
  echo "Please press any key to continue."
    read -n 1 -s
}
trap finish EXIT

javac *.java
java -jar Main.jar
java Main

#chmod 777 *.class
done