#base image
FROM openjdk:15-slim
#env
ENV LOG_LEVEL INFO
#copy jar from target to image
ADD target/docker-rest-1.0.jar /usr/src/docker-rest-1.0.jar
#set work dir to jar-file path
WORKDIR /usr/src
#port expose
EXPOSE 8080
#start jar inside container
ENTRYPOINT java -Dlogging.level.ru.docker=$LOG_LEVEL -Dspring.datasource.url=$JDBC_URL -Dspring.datasource.username=$JDBC_USER -Dspring.datasource.password=$JDBC_PASS -jar docker-rest-1.0.jar