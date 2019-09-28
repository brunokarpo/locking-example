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

ENV spring.datasource.url: "jdbc:postgresql://localhost:5432/locking-db"
ENV spring.datasource.username: locking-user
ENV spring.datasource.password: locking-password
ENV redis.url: "redis://localhost:6379"

ENTRYPOINT ["java", "-jar", "/app/locking-example.jar"]