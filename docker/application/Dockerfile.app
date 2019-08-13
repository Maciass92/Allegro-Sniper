FROM openjdk:8-jre-alpine

WORKDIR /app
COPY target/allegro.sniper-0.0.1-SNAPSHOT.jar /app/sniper-app.jar

EXPOSE 8080

CMD ["java", "-jar", "/app/sniper-app.jar"]