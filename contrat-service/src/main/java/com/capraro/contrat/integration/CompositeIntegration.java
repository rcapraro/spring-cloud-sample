package com.capraro.contrat.integration;

import com.capraro.contrat.model.Sinistre;
import com.capraro.contrat.model.Tiers;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;
import rx.Observable;
import rx.schedulers.Schedulers;

/**
 * Service d'intégration des Contrats avec les services Rest des Sinistres et des Tiers.
 * Created by Richard Capraro on 14/08/2015.
 */
@Service
@Slf4j
public class CompositeIntegration {

    @Autowired
    private RestOperations restOperations;

    @HystrixCommand(fallbackMethod = "defaultSinistre", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "30000"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
            @HystrixProperty(name = "execution.isolation.strategy", value = "SEMAPHORE")
    })
    public Observable<Sinistre> getSinistre(Long idContrat) {
        log.info("Appel de getSinistre");

        return Observable.<Sinistre>create(s -> {
            try {
                Sinistre sinistre = restOperations.getForObject("http://sinistre-service/sinistres/" + idContrat, Sinistre.class);
                s.onNext(sinistre);
                s.onCompleted();
            } catch (Exception e) {
                s.onError(e);
            }
        }).subscribeOn(Schedulers.io());
    }

    @HystrixCommand(fallbackMethod = "defaultTiers", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "30000"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
            @HystrixProperty(name = "execution.isolation.strategy", value = "SEMAPHORE")
    })
    public Observable<Tiers> getTiers(Long idContrat) {
        log.info("Appel de getTiers");

        return Observable.<Tiers>create(s -> {
            try {
                Tiers tiers = restOperations.getForObject("http://tiers-service/tiers/" + idContrat, Tiers.class);
                s.onNext(tiers);
                s.onCompleted();
            } catch (Exception e) {
                s.onError(e);
            }
        }).subscribeOn(Schedulers.io());
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
