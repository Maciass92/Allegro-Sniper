FROM openjdk:8-jre-alpine

WORKDIR /app
COPY target/allegro.sniper-0.0.1-SNAPSHOT.jar /app/sniper-app.jar
ENV JAVA_TOOL_OPTIONS -agentlib:jdwp=transport=dt_socket,address=6000,server=y,suspend=n

CMD ["java", "-jar", "/app/sniper-app.jar"]