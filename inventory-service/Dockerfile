FROM openjdk:8-jdk-alpine
ARG JAR_FILE
VOLUME /tmp
RUN mkdir -p /opt/inventory-service
COPY build/libs/${JAR_FILE} /opt/inventory-service/app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/opt/inventory-service/app.jar"]
