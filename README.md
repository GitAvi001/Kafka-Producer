# Kafka-Producer
This is a simlple implementation of Apache kafka using to produce messages based on topics to consumed by consumers using java.

## Prerequisites

- Java 17+
- Docker and Docker Compose
- Maven

## 1. Kafka Setup Using Docker
Create docker-compose.yml 
```bash
1. cd kafka-installation
2. touch docker-compose.yml
```

```yaml
version: '3'
services:
  zookeeper:
    image: wurstmeister/zookeeper
    container_name: zookeeper
    ports:
      - "2181:2181"
  kafka:
    image: wurstmeister/kafka
    container_name: kafka
    ports:
      - "9092:9092"
    environment:
      KAFKA_ADVERTISED_HOST_NAME: localhost
      KAFKA_ZOOKEEPER_CONNECT: zookeeper:2181
```

Start Kafka and Zookeeper:
```bash
docker-compose up -d
```

Ensure the docker containers are up and running 
```bash
docker ps
```

## 2. Project Setup

1. Create a new Maven project named as Kafka-app
2. Add the following dependencies to `pom.xml`:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>com.example</groupId>
    <artifactId>kafka-app</artifactId>
    <version>1.0-SNAPSHOT</version>
    <dependencies>
        <dependency>
            <groupId>org.apache.kafka</groupId>
            <artifactId>kafka-clients</artifactId>
            <version>3.7.1</version>
        </dependency>
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-api</artifactId>
            <version>2.0.12</version>
        </dependency>
    </dependencies>

    <properties>
        <maven.compiler.source>22</maven.compiler.source>
        <maven.compiler.target>22</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>
</project>
```

## 3. Start the producer

1. Access to the Kafka bin folder
```bash
1. docker exec -it kafka /bin/sh
2. cd /opt/
3. cd kafka
```
2. Creating a topic
```bash
./bin/kafka-topics.sh --create --zookeeper "zookeeper:2181" --replication-factor 1 --partition --topic <topic_name>
```
3.Listing topics
```
./bin/kafka-topics.sh --list --zookeeper "zookeeper:2181"
```
4.Start a consumer
```bash
./bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic <topic_name> --from beginning
```

5.Start the Runner in kafka-app

## Cleanup

## Stop and remove containers:
```bash
docker-compose down
```   

