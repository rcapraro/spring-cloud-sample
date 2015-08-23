# spring-cloud-sample

This is very simple set of microservices made with **Spring boot** and **Spring cloud**

* Eureka
* Hystrix commands
* Hystrix Dashboard
* A service (contrat-service) aggregating results of two other services with Spring Rest template, asynchronously with RxJava observables.
* Client load balancing with Ribbon
* Zuul proxy server
* (TODO) Config server

Start all services, you should then be able to view json content from <http://localhost:8765/contrat-service>, <http://localhost:8765/tiers-service> and <http://localhost:8765/sinistre-service> which are configured in application.yml as Zuul proxy routes.
