#!/bin/bash -x

export PORT=0

env

mvn clean
mvn ${MVN_PHASE:=install}
