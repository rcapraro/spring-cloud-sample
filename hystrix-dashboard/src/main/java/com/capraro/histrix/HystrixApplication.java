package com.capraro.histrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * Hystrix Dashboard Application Class.
 * Created by Richard Capraro on 07/08/2015.
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrixDashboard
@EnableTurbine
public class HystrixApplication {


    public static void main(String[] args) throws Exception {
        SpringApplication.run(HystrixApplication.class, args);
    }

}
