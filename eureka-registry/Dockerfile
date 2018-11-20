FROM openjdk:10
ADD ./target/eureka-registry-1.0.jar /usr/src/eureka-registry-1.0.jar
HEALTHCHECK --interval=30s --timeout=30s CMD curl -f http://localhost:8085/actuator/health || exit 1
EXPOSE 8091
WORKDIR usr/src
ENTRYPOINT ["java","-jar","eureka-registry-1.0.jar"]