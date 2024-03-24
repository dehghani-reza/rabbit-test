FROM openjdk:17-alpine

WORKDIR /my-project
COPY target/*.jar app.jar
CMD ["java","-jar","app.jar"]
EXPOSE 5672
