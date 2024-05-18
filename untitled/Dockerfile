# Use an OpenJDK image
FROM maven:3.8.1-openjdk-11

# Set the working directory
WORKDIR /app

# Copy the pom.xml file and the source code
COPY pom.xml /app
COPY src /app/src

# Run Maven to build the project
RUN mvn clean package -DskipTests

# Specify the command to run the application
CMD ["java", "-jar", "target/your-app.jar"]
