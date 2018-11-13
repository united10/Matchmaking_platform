FROM openjdk:10

ADD ./target/experience-0.0.1-SNAPSHOT.jar  /usr/src/experience-0.0.1-SNAPSHOT.jar
HEALTHCHECK --interval=30s --timeout=30s CMD curl -f http://localhost:8087/actuator/health || exit 1
EXPOSE 8087

WORKDIR usr/src
ENTRYPOINT ["java","-jar", "experience-0.0.1-SNAPSHOT.jar"]