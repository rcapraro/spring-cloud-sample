package com.capraro.sinistre.controller;

import com.capraro.sinistre.model.Sinistre;
import com.capraro.sinistre.repository.SinistreRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * Controller sinistre.
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
    public DeferredResult<Sinistre> sinistre(@PathVariable Long id) {
        log.info("Appel de GET sinistre avec id:{}", id);
        DeferredResult<Sinistre> result = new DeferredResult<>();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        result.setResult(sinistreRepository.getSinistre());
        return result;
    }
}
