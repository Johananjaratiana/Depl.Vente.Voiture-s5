# You can Replace this with the maven version of your app
FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
# Send you configuration file
COPY my-config /home/app
RUN mvn -f /home/app/pom.xml clean package spring-boot:repackage

FROM openjdk:11-jre-slim
# Mettez en parametre le port a utiliser
ARG PORT
ENV PORT=${PORT}
COPY --from=build /home/app/target/voiture-0.0.1-SNAPSHOT.jar /usr/local/lib/demo.jar
# Copy your configuration file in the base path of your project in deploiement
COPY --from=build /home/app/my-config .
ENTRYPOINT ["java","-Dserver.port=${PORT}","-jar","/usr/local/lib/demo.jar"]

