# syntax=docker/dockerfile:1

FROM openjdk:16-jre-alpine

RUN mkdir app

ADD /target/${JAR_FILE} /app/spring-docker-spotify.jar

