# Use the official Maven image to build the app
FROM maven:3.8.1-openjdk-11 AS build

# Set the working directory in the container
WORKDIR /app

# Copy the pom.xml file and the source code to the container
COPY pom.xml .
COPY src ./src

# Run Maven to build the app
RUN mvn clean package -DskipTests

# Use the official OpenJDK image to run the app
FROM openjdk:11-jre-slim

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose the port the app runs on (adjust if necessary)
EXPOSE 8080

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]
