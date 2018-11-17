FROM openjdk:10-jre

ADD ./target/SkillService-1.0.jar /usr/app/SkillService-1.0.jar

EXPOSE 8081

WORKDIR usr/app

ENTRYPOINT ["java","-jar", "SkillService-1.0.jar"]