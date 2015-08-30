package com.capraro.zuul;

import com.capraro.zuul.com.capraro.zuul.security.SecurityFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * Zuul server main application.
 * Created by Richard Capraro on 17/08/2015.
 */
@SpringBootApplication
@EnableZuulProxy
public class ZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class, args);
    }

    @Bean
    public SecurityFilter zuulSecurityFilter() {
        return new SecurityFilter();
    }

}
