FROM maven:3.6.3-jdk-11

ENV PROFILE=dev
ENV DISCORD_PREFIX=dev.
ENV DISCORD_PREFIXROLE=role.

RUN mkdir /app

WORKDIR /app

COPY pom.xml /app/pom.xml

RUN mvn -B dependency:resolve

EXPOSE 5432