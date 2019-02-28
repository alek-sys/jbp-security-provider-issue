#!/usr/bin/env bash

sdk use java 8.0.201-oracle
./gradlew clean build
cf push -f manifest-java8.yml
