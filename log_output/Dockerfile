# ---------- Build Stage -----------
FROM eclipse-temurin:21-jdk-alpine AS build

WORKDIR /build

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

RUN ./mvnw -B dependency:go-offline
COPY src src
RUN ./mvnw -B package
RUN ls -l

# ---------- Runtime stage ----------
FROM eclipse-temurin:21-jre-alpine
WORKDIR /log-output
COPY --from=build /build/target/*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]