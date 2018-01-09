# EventBus Kafka+Avro Implementation

Sends messages using Kafka and Avro (serialized with the Apache Avro library).
 
Both Consumer and Producers provided. For usage, check the tests.


## Installation

Add in your `pom.xml` file the jitpack.io repositories:

```xml
<repositories>
  <repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
  </repository>
</repositories>
```
  
Now add the package as a dependency: 

```xml
<dependencies>		
  <dependency>
    <groupId>com.nilportugues.eventbus</groupId>
    <artifactId>kafka-avro</artifactId>
    <version>${eventbus_kafkaavro.version}</version>
  </dependency>
</dependencies>  
```
