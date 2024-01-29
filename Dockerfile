# Use OpenJDK 17 as the base image
FROM openjdk:11-jdk-slim AS build

# Copy your source files and pom.xml into the image
COPY src /home/app/src
COPY pom.xml /home/app
COPY my-config /home/app

# Build your application
RUN mvn -f /home/app/pom.xml clean package spring-boot:repackage

# Start a new stage with OpenJDK 17 JRE
FROM openjdk:11-jre-slim

# Set the port environment variable
ARG PORT
ENV PORT=${PORT}

# Copy the built jar file and config from the build stage
COPY --from=build /home/app/target/voiture-0.0.1-SNAPSHOT.jar /usr/local/lib/demo.jar
COPY --from=build /home/app/my-config .

# Run the application
ENTRYPOINT ["java","-Dserver.port=${PORT}","-jar","/usr/local/lib/demo.jar"]
