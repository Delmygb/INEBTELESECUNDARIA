# ---------- Etapa 1: construir el .jar con Maven y JDK 17 ----------
FROM maven:3.9-eclipse-temurin-17 AS construccion
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn -B -DskipTests clean package

# ---------- Etapa 2: entorno de ejecución limpio (solo JRE 17) ----------
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=construccion /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-XX:MaxRAMPercentage=75", "-jar", "app.jar"]