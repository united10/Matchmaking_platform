FROM openjdk:10-jre

ADD ./target/spring-skill-1.0.jar /usr/app/spring-skill-1.0.jar

EXPOSE 8081

WORKDIR usr/app

ENTRYPOINT ["java","-jar", "spring-skill-1.0.jar"]