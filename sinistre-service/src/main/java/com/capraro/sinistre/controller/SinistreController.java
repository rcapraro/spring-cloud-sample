package com.capraro.sinistre.controller;

import com.capraro.sinistre.model.Sinistre;
import com.capraro.sinistre.repository.SinistreRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller sinsitre.
 * Created by Richard Capraro on 07/08/2015.
 */
@RestController
@Slf4j
public class SinistreController {

    @Autowired
    private SinistreRepository sinistreRepository;

    @RequestMapping(value = "/sinistres", method = RequestMethod.GET)
    public Iterable<Sinistre> sinistres() {
        return sinistreRepository.getSinistres();
    }

    @RequestMapping(value = "/sinistres/{id}", method = RequestMethod.GET)
    public Sinistre sinistre(@PathVariable Long id) {
        log.info("Appel de GET sinistre avec id:{}", id);
        return sinistreRepository.getSinistre();
    }
}
