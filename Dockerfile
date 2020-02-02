#base image
FROM openjdk:15-jdk-slim
#env
ENV SERVER_PORT 8080
ENV LOG_LEVEL INFO
ENV JDBC_URL 'jdbc:oracle:thin:@localhost:1521:XE'
#copy jar from target to image
ADD target/docker-rest-1.0.jar docker-rest-1.0.jar
#port expose
EXPOSE $SERVER_PORT
#start jar inside container
ENTRYPOINT java -Dlogging.level.ru.docker=$LOG_LEVEL -Dapp.datasource.jdbc-url=$JDBC_URL -Dserver.port=$SERVER_PORT -Doracle.jdbc.timezoneAsRegion=false -jar docker-rest-1.0.jar