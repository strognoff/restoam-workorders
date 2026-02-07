# Use an official OpenJDK runtime as a parent image
FROM openjdk:15-jdk

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file from the build output to the container
COPY build/libs/restoam-asset-0.0.5-SNAPSHOT-plain.jar app.jar

# Expose the port your application runs on
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
