# [ -- todo_app -- ]

# ---------- Build Stage -----------
FROM eclipse-temurin:21-jdk-alpine AS build

WORKDIR /build

ARG PORT=8080
ENV PORT=${PORT}
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Download dependencies (cached unless pom.xml changes)
RUN ./mvnw -B dependency:go-offline

# Copy source code
COPY src src

# Build app
RUN ./mvnw -B package


# ---------- Runtime stage ----------
FROM eclipse-temurin:21-jre-alpine

WORKDIR /todo_app

ENV PORT=${PORT}

COPY --from=build /build/target/todo_app-1.2.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]