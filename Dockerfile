FROM openjdk:8

COPY  ./target/docker-rest-0.0.1-SNAPSHOT.jar docker-rest.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar","docker-rest.jar"]