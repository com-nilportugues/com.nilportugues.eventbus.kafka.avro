# EventBus: Kafka+Avro

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
    <groupId>com.github.com-nilportugues</groupId>
    <artifactId>eventbus-kafka-avro</artifactId>
    <version>${eventbus-kafka-avro.version}</version>
  </dependency>
</dependencies>  
```

## Authors

* [Nil Portugués Calderó](https://nilportugues.com) (contact@nilportugues.com)


## License
The code base is licensed under the [MIT license](LICENSE).

