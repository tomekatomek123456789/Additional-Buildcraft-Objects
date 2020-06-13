#!/bin/bash
cd `dirname $0`
SCRIPTDIR=`pwd`
cd -
gradlew build jar
read -n1 -r -p "Press any key to continue..." key