FROM maven:3.8.6-openjdk-18-jdk-slim
COPY /src /app/src
COPY /pom.xml /app
RUN mvn -f /app/pom.xml clean packages -Dmaven.test.skip


FROM openjdk:16-jdk-alpine
EXPOSE 8080
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]