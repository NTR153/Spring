FROM openjdk:24
COPY target/docker_rest_demo.jar /tmp/docker_rest_demo.jar
# copies jar from java project (to be created earlier) to the image (to be created)
CMD ["java", "-jar", "/tmp/docker_rest_demo.jar"]
# sets default command for the image

# OR

# FROM openjdk:24
# ADD target/docker_rest_demo.jar /tmp/docker_rest_demo.jar
# ENTRYPOINT ["java", "-jar", "/tmp/docker_rest_demo.jar"]

EXPOSE 8080