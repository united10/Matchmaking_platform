FROM openjdk:10

ADD ./target/eureka-registry-1.0.jar /usr/src/eureka-registry-1.0.jar
EXPOSE 8091
WORKDIR usr/src
ENTRYPOINT ["java","-jar","eureka-registry-1.0.jar"]