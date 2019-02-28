#!/usr/bin/env bash

sdk use java 11.0.2-open
./gradlew clean build
cf push -f manifest-java11.yml
