# spring-cloud-sample

This is a very simple sample made with Spring boot and Spring cloud

* Eureka
* Hystrix commands
* Hystrix Dashboard
* Two services communicating with Spring rest template
* Client load balacing with Ribbon
* Zuul proxy server
* (TODO) Config server

Start all services, you should then be able to view json content from http://localhost:8765/contrat-service and http://localhost:8765/sinistre-service which are configured in application.yml as Zuul proxy routes.
