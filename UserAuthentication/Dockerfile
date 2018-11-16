FROM openjdk:10

ADD ./target/userAuthentication-0.0.1-SNAPSHOT.jar /usr/src/userAuthentication-0.0.1-SNAPSHOT.jar
HEALTHCHECK --interval=30s --timeout=30s CMD curl -f http://localhost:8088/actuator/health || exit 1
EXPOSE 8088
WORKDIR usr/src
ENTRYPOINT ["java","-jar","userAuthentication-0.0.1-SNAPSHOT.jar"]

