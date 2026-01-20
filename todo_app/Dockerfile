# ---- todo_app ----
FROM eclipse-temurin:21-jdk-alpine

ARG PORT=8080
ENV PORT=${PORT}

WORKDIR /todo_app
COPY . .
RUN ./mvnw -B clean package

ENTRYPOINT ["java","-jar","target/todo_app-1.2.jar"]