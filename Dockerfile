FROM openjdk:8

COPY build/libs/sales-microservice-0.1.0.jar app.jar

EXPOSE 8080
ENV PORT=8080


CMD java -Dserver.port=$PORT -jar app.jar