# Use an appropriate base image
FROM maven:3.8.1-openjdk-8

# Set working directory
WORKDIR /app

# Copy pom.xml and source code
COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src

# Run Maven package command
RUN mvn clean package -DskipTests

# Command to run the application or tests
CMD ["mvn", "test"]
