# ----------- Build Stage -------------
FROM maven:3.9.9-eclipse-temurin-17 AS build
WORKDIR /app

# Copy Maven project files
COPY pom.xml .
COPY src ./src

# Build the JAR using Maven, skipping tests for faster build
RUN mvn clean package -DskipTests

# ----------- Run Stage -------------
FROM eclipse-temurin:17-jre
WORKDIR /app

# Copy the built JAR from the build stage
COPY --from=build /app/target/*.jar app.jar

# Spring Boot datasource + JPA configs (for PostgreSQL)
ENV SPRING_DATASOURCE_URL=jdbc:postgresql://patient-service-db:5432/patientdb
ENV SPRING_DATASOURCE_USERNAME=postgres
ENV SPRING_DATASOURCE_PASSWORD=password
ENV SPRING_DATASOURCE_DRIVER_CLASS_NAME=org.postgresql.Driver
ENV SPRING_JPA_SHOW_SQL=true
ENV SPRING_JPA_HIBERNATE_DDL_AUTO=update
ENV SPRING_JPA_PROPERTIES_HIBERNATE_DIALECT=org.hibernate.dialect.PostgreSQLDialect
ENV SPRING_JPA_OPEN_IN_VIEW=false
ENV SPRING_SQL_INIT_MODE=always

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
