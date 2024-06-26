# Use an official OpenJDK runtime as the base image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the compiled Spring Boot application JAR file into the container at /app
COPY build/libs/email-service-1.0.0.jar app.jar

# Expose the port that the Spring Boot application listens on
EXPOSE 8082

# Define the command to run the Spring Boot application when the container starts
CMD ["java", "-jar", "app.jar"]
