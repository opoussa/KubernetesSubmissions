FROM eclipse-temurin:21-jdk-alpine

WORKDIR /log_output

COPY target/log-output-1.1.jar log-output.jar

ENTRYPOINT ["java","-jar","log-output.jar"]