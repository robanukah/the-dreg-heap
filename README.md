# The Dreg Heap
Summer 2017 skill improvement and best practice usage. Blog with Spring Boot, Spring Data MongoDB, JWT authentication.

[![Dependency Status](https://www.versioneye.com/user/projects/5935acbf368b08001bbdb614/badge.svg?style=flat-square)](https://www.versioneye.com/user/projects/5935acbf368b08001bbdb614)

## Technologies
* Spring Boot as base
* Spring Data as db access technology
* MongoDB as db
* Spring AOP as audit, logging and exception handling technology
* JWT authentication as security 
* Apache Maven as project management and comprehension tool
* Checkstyle, PMD, Findbugs as quality checkers
* Travis build for build overview
* Versioneye for dependencies overview
* Coveralls for code coverage overview

## Road Map
1) Spring Boot base
2) Support for all usable plugins (Checkstyle, PMD, Findbugs)
3) Add Versioneye
4) Add Coveralls and Travis build

## Running

 * If you have gradle installed use next
 
```
 gradle bootRun
```

* Otherwise

```
./gradlew build
java -jar build/libs/dreg-heap-backend-0.0.1-SNAPSHOT.jar

```
