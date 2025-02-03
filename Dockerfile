FROM openjdk
EXPOSE 8090
RUN echo "hello developments"
COPY ./build/libs/change.my.name-0.0.1-SNAPSHOT.jar /app/
WORKDIR /app/
ENTRYPOINT ["java"]
CMD ["-jar", "app/change.my.name-0.0.1-SNAPSHOT.jar"]