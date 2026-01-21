# 1. ETAPA DE CONSTRUCCIÓN - Compila tu proyecto
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# 2. ETAPA DE EJECUCIÓN - Corre tu aplicación
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /app/target/luluncotoapp-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]