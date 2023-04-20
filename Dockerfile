FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/noithatmoho_backend.jar app.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"]
EXPOSE 9080
