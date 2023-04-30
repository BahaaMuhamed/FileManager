FROM openjdk:11-jdk-slim
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/STC.jar
ADD ${JAR_FILE} STC.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/STC.jar"]