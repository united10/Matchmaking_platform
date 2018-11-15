FROM openjdk:10

ADD ./target/LocationService-0.0.1-SNAPSHOT.jar /usr/src/LocationService-0.0.1-SNAPSHOT.jar
HEALTHCHECK --interval=30s --timeout=30s CMD curl -f http://localhost:8084/actuator/health || exit 1
EXPOSE 8084

WORKDIR usr/src
ENTRYPOINT ["java","-jar", "LocationService-0.0.1-SNAPSHOT.jar"]
