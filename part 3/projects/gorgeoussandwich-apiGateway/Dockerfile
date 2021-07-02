FROM openjdk:8-jre-alpine
EXPOSE 8085
ADD target/gorgeoussandwich-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]