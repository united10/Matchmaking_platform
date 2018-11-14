FROM openjdk:10

ADD ./target/ProjectService-0.0.1-SNAPSHOT.jar /usr/src/ProjectService-0.0.1-SNAPSHOT.jar
HEALTHCHECK --interval=30s --timeout=30s CMD curl -f http://localhost:8083/actuator/health || exit 1
EXPOSE 8083

WORKDIR usr/src
ENTRYPOINT ["java","-jar", "ProjectService-0.0.1-SNAPSHOT.jar"]