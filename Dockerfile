FROM eclipse-temurin:18-jdk-alpine
VOLUME /tmp
ADD target/noithatmoho-backend.jar app.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"]
EXPOSE 9080
