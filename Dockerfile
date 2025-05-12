# Use Java 17 as base image
FROM eclipse-temurin:17-jdk-focal

# Prevent interactive prompts during package installation
ENV DEBIAN_FRONTEND=noninteractive

# Install basic dependencies
RUN apt-get update && \
    apt-get install -y \
    maven \
    curl \
    wget \
    gnupg2 \
    unzip \
    && rm -rf /var/lib/apt/lists/*

# Install Chrome dependencies
RUN apt-get update && \
    apt-get install -y \
    xvfb \
    libxi6 \
    libgconf-2-4 \
    && rm -rf /var/lib/apt/lists/*

# Install Chrome
RUN curl -fsSL https://dl-ssl.google.com/linux/linux_signing_key.pub | gpg --dearmor -o /usr/share/keyrings/google-chrome.gpg && \
    echo "deb [arch=amd64 signed-by=/usr/share/keyrings/google-chrome.gpg] http://dl.google.com/linux/chrome/deb/ stable main" | tee /etc/apt/sources.list.d/google-chrome.list && \
    apt-get update && \
    apt-get install -y google-chrome-stable && \
    rm -rf /var/lib/apt/lists/*

# Install Allure
RUN curl -o allure-2.25.0.tgz -Ls https://github.com/allure-framework/allure2/releases/download/2.25.0/allure-2.25.0.tgz && \
    tar -zxvf allure-2.25.0.tgz -C /opt/ && \
    ln -s /opt/allure-2.25.0/bin/allure /usr/bin/allure && \
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