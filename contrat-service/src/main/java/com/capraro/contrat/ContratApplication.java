package com.capraro.contrat;

import com.capraro.contrat.controller.SecurityFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.context.annotation.Bean;

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

    @Bean
    public SecurityFilter zuulSecurityFilter() {
        return new SecurityFilter();
    }

}
