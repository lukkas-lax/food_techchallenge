FROM openjdk:21
COPY target/food_techchallenge-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
ENV DEBUG=True

# Set an environment variable for your application's port
ENV WEBSITED_PORT=80
EXPOSE 80