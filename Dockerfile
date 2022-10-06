FROM openjdk:11

MAINTAINER shbp87@gmail.com

ADD target/BigWork-1.0-SNAPSHOT.jar docker.jar

ENTRYPOINT  ["java", "-jar", "docker.jar" ]