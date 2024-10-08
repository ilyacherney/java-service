# Use an official OpenJDK runtime as a parent image
FROM openjdk:20

# Set the working directory in the container
WORKDIR /app

# Copy the jar file into the container at /app
COPY target/kafka-test-0.0.1-SNAPSHOT.jar /app/myapp.jar

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "myapp.jar"]