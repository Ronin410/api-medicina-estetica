# Base image
FROM openjdk:17-alpine
# Install maven
RUN apk add maven

WORKDIR /app
COPY . .

# Changes to the application that do not change dependencies in pom.xml
# should not trigger the next command to be run again
COPY pom.xml .
RUN mvn dependency:go-offline

# Changes to the application should invalidate the docker build cache
COPY src /app/src

CMD mvn spring-boot:run