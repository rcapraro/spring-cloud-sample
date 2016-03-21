package com.capraro.contrat.controller;

import com.capraro.contrat.integration.CompositeIntegration;
import com.capraro.contrat.model.Contrat;
import com.capraro.contrat.model.TypeSinistre;
import com.capraro.contrat.repository.ContratRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;
import rx.Observable;

import java.util.Arrays;

/**
 * Controller contrat.
 * Created by Richard Capraro on 07/08/2015.
 */
@RestController
@Slf4j
public class ContratController {

    @Autowired
    private ContratRepository contratRepository;

    @Autowired
    private CompositeIntegration compositeIntegration;

    @RequestMapping(value = "/contrats", method = RequestMethod.GET)
    public Iterable<Contrat> contrats() {
        return contratRepository.getContrats();
    }


    @RequestMapping(value = "/contrats/{id}", method = RequestMethod.GET)
    public DeferredResult<Contrat> contrat(@PathVariable Long id, @RequestParam(required = false, defaultValue = "MATERIEL") TypeSinistre typeSinistre) {
        log.info("Appel de /contrats/{id]");

        Observable<Contrat> contratWithDetails = getContratWithDetails(id, typeSinistre);
        return toDeferredResult(contratWithDetails);
    }

    private Observable<Contrat> getContratWithDetails(long id, TypeSinistre typeSinistre) {

        Contrat contrat = contratRepository.getContrat();

        return Observable.zip(
                compositeIntegration.getSinistre(id),
                compositeIntegration.getTiers(id),
                (sinistre, tiers) -> {
                    contrat.setSinistres(Arrays.asList(sinistre));
                    contrat.setTiers(tiers);
                    return contrat;
                }
        );
    }

    public DeferredResult<Contrat> toDeferredResult(Observable<Contrat> contratWithDetails) {
        DeferredResult<Contrat> result = new DeferredResult<>();
        contratWithDetails.subscribe(contrat -> result.setResult(contrat));
        return result;
    }

}
