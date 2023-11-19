FROM openjdk:8-jre-slim
WORKDIR /praticandoAPI
COPY target/*.jar /praticandoAPI/praticandoAPI-0.0.1-SNAPSHOT.jar
EXPOSE 9090
CMD java -XX:+UseContainerSupport -Xmx512m -Dserver.port=9090 -jar praticandoAPI-0.0.1-SNAPSHOT.jar 



