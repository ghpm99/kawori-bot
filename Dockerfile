FROM maven:3.6.3-jdk-11

ENV PROFILE=dev

RUN mkdir /app

WORKDIR /app

COPY pom.xml /app/pom.xml

RUN mvn -B dependency:resolve

EXPOSE 5432