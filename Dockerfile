#### Builder Stage ####
FROM maven:3.8.4-jdk-8 AS builder

# Copy the pom.xml to download dependencies
COPY pom.xml .

# Download the project dependencies
RUN mvn dependency:go-offline

# Copy the application source code
COPY src/ src/

# Build the application
RUN mvn package -Dmaven.test.skip=true

#### Runtime Stage ####
FROM tomcat:8.5.72-jdk8-openjdk-slim

# Copy the WAR file built in the builder stage to Tomcat's webapps directory
COPY --from=builder target/Food_Master.war /usr/local/tomcat/webapps/

# Expose port 8080 for Tomcat
EXPOSE 8081

# Start Tomcat when the container runs
CMD ["catalina.sh", "run"]
