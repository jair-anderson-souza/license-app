# License App

This project was developed with [Spring Boot](https://spring.io/guides/gs/spring-boot/) version 2.3.0.RELEASE.

## Getting Started 

## Follow next steps to deploy application: 

###### Run config-server/ 
`mvn clean spring-boot:run`

###### Run eureka-server/
`mvn clean spring-boot:run`

###### Run order-service/
`mvn clean spring-boot:run`

###### Run license-server
`mvn clean spring-boot:run`


## Development server

All applications must be running in dev profile


java -javaagent:/opt/newrelic/newrelic.jar -jar /home/jair-silva/workspace/license-app/license-service/target/license-service-1.0.jar