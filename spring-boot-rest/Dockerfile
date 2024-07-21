FROM amazoncorretto:22-alpine-jdk
COPY target/aws-springboot-rest.jar aws-springboot-rest.jar
ENTRYPOINT ["java", "-jar", "aws-springboot-rest.jar"]
EXPOSE 5000