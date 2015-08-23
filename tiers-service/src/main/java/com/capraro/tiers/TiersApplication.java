package com.capraro.tiers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Tiers api Application Class.
 * Created by Richard Capraro on 07/08/2015.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class TiersApplication {

    public static void main(String[] args) {
        SpringApplication.run(TiersApplication.class, args);
    }
}
