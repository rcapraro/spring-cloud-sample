package com.capraro.sinistre;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * Sinistre api Application Class.
 * Created by Richard Capraro on 07/08/2015.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SinistreApplication {

    public static void main(String[] args) {
        SpringApplication.run(SinistreApplication.class, args);
    }
}
