# Use Java 17 as the base image
FROM eclipse-temurin:17-jdk

# Install Maven and Allure
RUN apt-get update && \
    apt-get install -y maven gnupg2 curl unzip && \
    curl -o allure-2.25.0.tgz -Ls https://github.com/allure-framework/allure2/releases/download/2.25.0/allure-2.25.0.tgz && \
    tar -zxvf allure-2.25.0.tgz -C /opt/ && \
    ln -s /opt/allure-2.25.0/bin/allure /usr/bin/allure && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/* && \
    rm allure-2.25.0.tgz

# Set the working directory
WORKDIR /app

# Copy the project files
COPY pom.xml .
COPY src ./src

# Install dependencies
RUN mvn dependency:go-offline

# Create a directory for the Allure results
RUN mkdir -p /app/allure-results

# Run the tests and generate the Allure report
CMD mvn clean test -Dsurefire.useFile=false && mvn allure:report && \
    echo "Allure report generated at: /app/target/allure-report" && \
    echo "To view the report, mount the volume containing /app/target/allure-report to your host machine" 