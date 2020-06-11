FROM openjdk:11-jdk-slim

# Default to UTF-8 file.encoding
ENV LANG C.UTF-8

# Default copy (Gradle)
COPY ./build/libs/*.jar /api/app.jar

# Default workspace dir
RUN ls /api
WORKDIR /api


EXPOSE 8080
# no root execution
USER www-data

ENTRYPOINT ["java", "-jar", "/api/app.jar"]
