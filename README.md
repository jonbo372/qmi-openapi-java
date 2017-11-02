# qmi-openapi-java

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/tw.com.mitake/qmi-openapi/badge.svg)](https://maven-badges.herokuapp.com/maven-central/tw.com.mitake/qmi-openapi)

Qmi OpenAPI for Java

## Dependency

```xml
<dependency>
  <groupId>tw.com.mitake</groupId>
  <artifactId>qmi-openapi</artifactId>
  <version>0.2.0</version>
</dependency>
```

## How to use

### **AT FIRST**

```java
Qmi qmi = Qmi.init("token");
```

### Send a message to timeline

```java
qmi.postToTimeline("Hello World");
```
