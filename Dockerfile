FROM eclipse-temurin:21-jdk

WORKDIR /app

# копіюємо ВСЮ структуру quarkus-app
COPY build/quarkus-app/ ./

EXPOSE 8080

CMD ["java", "-jar", "quarkus-run.jar"]
