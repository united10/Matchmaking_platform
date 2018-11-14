FROM openjdk:10-jre

ADD ./target/spring-skill-0.0.1-SNAPSHOT.jar /usr/app/spring-skill-0.0.1-SNAPSHOT.jar

EXPOSE 8081

WORKDIR usr/app

ENTRYPOINT ["java","-jar", "spring-skill-0.0.1-SNAPSHOT.jar"]