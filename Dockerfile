#Build application
FROM openjdk:8-alpine as builder
WORKDIR /home/maven/src
COPY . /home/maven/src
RUN ./mvnw clean install


# Run application
FROM openjdk:8-alpine
LABEL maintainer="Bruno Nogueira <ti.brunonogueira at gmail.com>"
WORKDIR /app
COPY --from=builder /home/maven/src/target/*.jar locking-example.jar

ENTRYPOINT ["java", "-jar", "/app/locking-example.jar"]