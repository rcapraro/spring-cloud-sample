package com.capraro.contrat.integration;

import com.capraro.contrat.model.Sinistre;
import com.capraro.contrat.model.Tiers;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.command.ObservableResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import rx.Observable;

/**
 * Service d'intégration des Contrats avec les services Rest des Sinistres et des Tiers.
 * Created by Richard Capraro on 14/08/2015.
 */
@Service
@Slf4j
public class CompositeIntegration {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "defaultSinistre", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "500"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "3000")
    })
    public Observable<Sinistre> getSinistre(Long idContrat) {
        log.info("Appel de getSinistre");
        return new ObservableResult<Sinistre>() {
            public Sinistre invoke() {
                return restTemplate.getForObject("http://sinistre-service/sinistres/" + idContrat, Sinistre.class);
            }
        };
    }

    @HystrixCommand(fallbackMethod = "defaultTiers", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "500"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "3000")
    })
    public Observable<Tiers> getTiers(Long idContrat) {
        log.info("Appel de getTiers");
        return new ObservableResult<Tiers>() {
            public Tiers invoke() {
                return restTemplate.getForObject("http://tiers-service/tiers/" + idContrat, Tiers.class);
            }
        };
    }

    private Sinistre defaultSinistre(Long idContrat) {
        log.info("Erreur lors de l'appel de getSinistre...fallback method");
        return null;
    }

    private Tiers defaultTiers(Long idContrat) {
        log.info("Erreur lors de l'appel de getTiers...fallback method");
        return null;
    }

}
