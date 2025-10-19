# Use OpenJDK 21 as base image
FROM eclipse-temurin:21-jdk-alpine

# Set working directory
WORKDIR /app

# Copy the WAR file from your local build
COPY build/libs/coffee-shop-telegram-bot-0.0.1-SNAPSHOT.war app.war

# Expose Spring Boot default port
EXPOSE 8080

# Run the Spring Boot WAR
CMD ["java", "-jar", "app.war"]
