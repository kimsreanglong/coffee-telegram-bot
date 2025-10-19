# Stage 1: Build using Gradle
FROM gradle:7.6-jdk21-alpine AS builder
WORKDIR /app
COPY . .
RUN gradle clean bootJar --no-daemon

# Stage 2: Run the app
FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY --from=builder /app/build/libs/coffee-shop-telegram-bot-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
