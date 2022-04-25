FROM maven:3.8.5-openjdk-17
COPY . ./hr-calendar
WORKDIR ./hr-calendar
RUN mvn install
WORKDIR ./security-service
CMD ["mvn","exec:java"]