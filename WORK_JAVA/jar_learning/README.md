JAR, WAR
## Content
    1. Introduction
    2. Basic package jar
    3. Trouble Shoot

## Introduction
This Learning Project is to help xinxin understand jar, war and java development.
* Ref: 
- Basic operation of package jar/war: https://www.cnblogs.com/EasonJim/p/6481704.html?utm_source=itdadao&utm_medium=referral
- Java JAR/WAR/EAR file folder explanation: http://www.cnblogs.com/EasonJim/p/6498804.html

## Basic package jar ---  let's play code
### Coding, Compile & Run
1. Write first piece code ./Myprogram.java
2. Use javac to compile java source file
    jar_learning>`javac jartest/MyProgram.java` 
3. Run class file
    jar_learning> `java jartest.MyProgram`

#### Add meta file, package, show detials, and extra from jar 
0. New a MANIFEST.MF file under jar_learning
1. package 
    `jar cf MyApp.jar jartest\MyProgram.class`
2. Show detail 
    `jar tvf MyApp.jar`
3. extra jar
    `jar xf MyApp.jar`
4. New a runable jar file
    `jar cvfm MyApp.jar MANIFEST.MF jartest\MyProgram.class`
5. Run this runable jar file 
    `java -jar MyApp.jar`
    
## Trouble Shoot
1. javac is not recognized
Solution: Add %JAVA_HOME%/bin to System variable path; then, restart cmd and Editor again.
2. 