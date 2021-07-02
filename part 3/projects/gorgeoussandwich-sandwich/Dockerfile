FROM openjdk:8-jre-alpine
EXPOSE 8087
ADD target/gorgeoussandwich-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]