FROM openjdk:8-jdk-alpine
EXPOSE 8102
ARG JAR_FILE=/target/myorder-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} myorder-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/myorder-0.0.1-SNAPSHOT.jar"]