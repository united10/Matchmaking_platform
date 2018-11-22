FROM openjdk:10

ADD ./target/InterestService-0.0.1-SNAPSHOT.jar  /usr/src/InterestService-0.0.1-SNAPSHOT.jar
HEALTHCHECK --interval=30s --timeout=30s CMD curl -f http://localhost:8095/actuator/health || exit 1
EXPOSE 8095
WORKDIR usr/src
ENTRYPOINT ["java","-jar", "InterestService-0.0.1-SNAPSHOT.jar"]
