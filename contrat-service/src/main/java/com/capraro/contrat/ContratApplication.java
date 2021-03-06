package com.capraro.contrat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * Contrat api Application Class.
 * Created by Richard Capraro on 07/08/2015.
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableTurbine
public class ContratApplication {


    public static void main(String[] args) {
        SpringApplication.run(ContratApplication.class, args);
    }
}
