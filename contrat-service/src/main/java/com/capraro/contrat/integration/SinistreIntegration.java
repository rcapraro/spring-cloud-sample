package com.capraro.contrat.integration;

import com.capraro.contrat.model.Sinistre;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Service d'intégration des Contrats avec le service Rest des Sinistres.
 * Created by Richard Capraro on 14/08/2015.
 */
@Service
@Slf4j
public class SinistreIntegration {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "defaultSinistre", commandProperties  = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "500"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "3000")
    })
    public Sinistre getSinistre(Long idContrat) {
        log.info("Appel de getSinistre");
        return restTemplate.getForObject("http://sinistre-service/sinistres/" + idContrat, Sinistre.class);
    }

    private Sinistre defaultSinistre(Long idContrat) {
        log.info("Erreur lors de l'appel de getSinistre...fallback method");
        return null;
    }
}
