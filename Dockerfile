# Build stage

FROM maven:3.8.6-openjdk-11-slim as build

WORKDIR /app

COPY mvnw .
COPY pom.xml .
COPY src src

RUN chmod +x mvnw
RUN mvn package -DskipTests

# Package stage
FROM amazoncorretto:11-alpine3.17

COPY --from=build /app/target/RoomReservation-0.0.1-SNAPSHOT.jar /app/reservation.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/reservation.jar"]