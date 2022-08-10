#gradle proj
FROM  adoptopenjdk/openjdk8:alpine-jre
VOLUME /tmp
ADD /build/libs/backend-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-Duser.timezone=Europe/Moscow", "-jar", "/app.jar"]

