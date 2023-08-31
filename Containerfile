FROM gradle:8.3.0-jdk8 as build
WORKDIR /app
COPY . .
RUN ls -ltr
RUN ./gradlew build

RUN find . -name "*.jar"

FROM openjdk:8
WORKDIR /app
COPY --from=build /app/build/libs/log-generator-1.0.jar .
RUN ls -ltr

CMD [ "java","-jar","log-generator-1.0.jar" ]