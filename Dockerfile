FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY build/libs/*.war app.war
ENTRYPOINT ["java", "-jar", "app.war"]
