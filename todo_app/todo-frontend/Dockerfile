# [ -- todo_app -- ]

# ---------- Build Stage -----------
FROM eclipse-temurin:21-jdk-alpine AS build

WORKDIR /build

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

WORKDIR /todo_frontend

COPY --from=build /build/target/todo_frontend-1.2.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]