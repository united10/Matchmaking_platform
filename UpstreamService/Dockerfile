FROM openjdk:10

ADD ./target/UpstreamService-0.0.1-SNAPSHOT.jar /usr/src/UpstreamService-0.0.1-SNAPSHOT.jar
HEALTHCHECK --interval=30s --timeout=30s CMD curl -f http://localhost:9191/actuator/health || exit 1
EXPOSE 9191
WORKDIR usr/src
ENTRYPOINT ["java","-jar","UpstreamService-0.0.1-SNAPSHOT.jar"]