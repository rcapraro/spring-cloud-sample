package com.capraro.turbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.amqp.EnableTurbineAmqp;

/**
 * Hystrix Dashboard Application Class.
 * Created by Richard Capraro on 07/08/2015.
 */
@SpringBootApplication
@EnableTurbineAmqp
public class TurbineAMQPApplication {


    public static void main(String[] args) throws Exception {
        SpringApplication.run(TurbineAMQPApplication.class, args);
    }

}
