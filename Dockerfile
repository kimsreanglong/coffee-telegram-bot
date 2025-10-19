
# Use OpenJDK 21 as base image
FROM eclipse-temurin:21-jdk-alpine

# Set working directory in container
WORKDIR /app

# Copy Gradle build output
COPY build/libs/coffee-shop-telegram-bot-0.0.1-SNAPSHOT.war .

# Expose the port Spring Boot runs on
EXPOSE 8080

# Run the Spring Boot application
CMD ["sh", "-c", "java -Dserver.port=$PORT -war coffee-shop-telegram-bot-0.0.1-SNAPSHOT.war"]
