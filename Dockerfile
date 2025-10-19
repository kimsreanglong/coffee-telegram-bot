# Use Java 21 JDK image
FROM eclipse-temurin:21-jdk-alpine

# Set work directory inside container
WORKDIR /app

# Copy WAR file into container
COPY build/libs/coffee-shop-telegram-bot-0.0.1-SNAPSHOT.war app.war

# Expose port your app runs on
EXPOSE 8080

# Run the WAR file
ENTRYPOINT ["java","-jar","app.war"]
