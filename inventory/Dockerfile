# Use a base image that includes Java
FROM openjdk:17-jdk-slim

#Define the version argument with a default value
ARG VERSION=0.0.1-SNAPSHOT

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file from target directory to the container's directory
COPY target/inventory-${VERSION}.jar /app/inventory-service.jar

# Expose the port the app will run on
EXPOSE 8080

# Run the application
ENTRYPOINT [ "java", "-jar", "/app/inventory-service.jar"]