## Introduction
This tiny project is help myself to be familiar with Maven.
Using Maven to create, build the project.
[Maven in 5 Minutes](https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html) 
## Maven Life Cycle
validate - checks if the project is correct and all information is available

compile - compiles source code in binary artifacts

test - executes the tests

package - takes the compiled code and package it, for example

integration-test - takes the packaged result and executes additional tests, which require the packaging

verify - performs checks if the package is valid

install - install the result of the package phase into the local Maven repository

deploy - deploys the package to a target, i.e. remote repository