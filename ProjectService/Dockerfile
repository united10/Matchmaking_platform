FROM openjdk:10

<<<<<<< HEAD
ADD ./target/ProjectService-0.0.1-SNAPSHOT.jar /usr/src/ProjectService-0.0.1-SNAPSHOT.jar
=======
ADD ./target/ProjectService-1.0.jar /usr/src/ProjectService-1.0.jar
>>>>>>> 9e7726043531d9d4e524b8a080637846f68a9cb7
HEALTHCHECK --interval=30s --timeout=30s CMD curl -f http://localhost:8083/actuator/health || exit 1
EXPOSE 8083

WORKDIR usr/src
<<<<<<< HEAD
ENTRYPOINT ["java","-jar", "ProjectService-0.0.1-SNAPSHOT.jar"]
=======
ENTRYPOINT ["java","-jar", "ProjectService-1.0.jar"]
>>>>>>> 9e7726043531d9d4e524b8a080637846f68a9cb7
