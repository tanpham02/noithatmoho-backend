FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
ADD target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
EXPOSE 9080
