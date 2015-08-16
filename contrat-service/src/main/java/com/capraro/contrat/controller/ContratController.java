package com.capraro.contrat.controller;

import com.capraro.contrat.integration.SinistreIntegration;
import com.capraro.contrat.model.Contrat;
import com.capraro.contrat.model.Sinistre;
import com.capraro.contrat.repository.ContratRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    private SinistreIntegration sinistreIntegration;

    @RequestMapping(value = "/contrats", method = RequestMethod.GET)
    public Iterable<Contrat> contrats() {
        return contratRepository.getContrats();
    }


    @RequestMapping(value = "/contrats/{id}", method = RequestMethod.GET)
    public Contrat contrat(@PathVariable Long id) {
        log.info("Appel de /contrats/{id]");
        Sinistre sinistre = sinistreIntegration.getSinistre(id);
        log.info("Sinistre récupéré");
        Contrat contrat = Contrat.builder().id(id).build();
        contrat.setSinistres(Arrays.asList(sinistre));
        return contrat;
    }
}
