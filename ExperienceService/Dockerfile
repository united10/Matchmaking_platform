FROM openjdk:10

<<<<<<< HEAD
ADD ./target/experience-0.0.1-SNAPSHOT.jar  /usr/src/experience-0.0.1-SNAPSHOT.jar
=======
ADD ./target/ExperienceService-1.0.jar  /usr/src/ExperienceService-1.0.jar
>>>>>>> 9e7726043531d9d4e524b8a080637846f68a9cb7
HEALTHCHECK --interval=30s --timeout=30s CMD curl -f http://localhost:8087/actuator/health || exit 1
EXPOSE 8087

WORKDIR usr/src
<<<<<<< HEAD
ENTRYPOINT ["java","-jar", "experience-0.0.1-SNAPSHOT.jar"]
=======
ENTRYPOINT ["java","-jar", "ExperienceService-1.0.jar"]
>>>>>>> 9e7726043531d9d4e524b8a080637846f68a9cb7
