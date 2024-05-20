FROM maven:3.8.6-openjdk-18-jdk-slim
COPY /src /app/src
COPY /pom.xml /app
RUN mvn -f /app/pom.xml clean packages -Dmaven.test.skip


FROM openjdk:18-jdk-slim
EXPOSE 8080
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]