FROM maven:3.6.3-jdk-11-slim

WORKDIR /app

COPY ./target/RoomReservation-0.0.1-SNAPSHOT.jar /app/reservation.jar
ENTRYPOINT ["java", "-jar", "/app/reservation.jar"]

