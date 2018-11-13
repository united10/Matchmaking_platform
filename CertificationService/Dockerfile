FROM openjdk:10

ADD ./target/CertificationService-0.0.1-SNAPSHOT.jar /usr/src/CertificationService-0.0.1-SNAPSHOT.jar
HEALTHCHECK --interval=30s --timeout=30s CMD curl -f http://localhost:8085/actuator/health || exit 1
EXPOSE 8085
WORKDIR usr/src
ENTRYPOINT ["java","-jar","CertificationService-0.0.1-SNAPSHOT.jar"]