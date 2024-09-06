# Kinde Springboot Core

Welcome to the Kinde Springboot Core!

## Overview
The Kinde Springboot Core functionality. This project is responsible for bootstrapping a Springboot project, and applying the appropriate configuration and enabling necessary services to manage and connect to Kinde.

### Maven
This project should not be included directly, rather use the kinde-springboot-starter.
```xml
    <dependency>
      <groupId>com.kinde.spring</groupId>
      <artifactId>kinde-springboot-starter</artifactId>
      <version>2.0.0</version>
    </dependency>
```
### Gradle
In order to use the SDK with a Gradle build process please use the following dependancy.
```groovy
    configuration('com.kinde.spring:kinde-springboot-starter:2.0.0')
```