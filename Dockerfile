# Use Java 23 as the base image
FROM eclipse-temurin:23-jdk

# Install Maven
RUN apt-get update && \
    apt-get install -y maven && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

# Set the working directory
WORKDIR /app

# Copy the project files
COPY pom.xml .
COPY src ./src

# Install dependencies
RUN mvn dependency:go-offline

# Run the tests
CMD ["mvn", "test"] 