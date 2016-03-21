package com.capraro.tiers.controller;

import com.capraro.tiers.model.Adresse;
import com.capraro.tiers.model.Tiers;
import com.capraro.tiers.repository.TiersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * Controller tiers.
 * Created by Richard Capraro on 07/08/2015.
 */
@RestController
@Slf4j
public class TiersController {

    @Autowired
    private TiersRepository tiersRepository;

    @RequestMapping(value = "/tiers", method = RequestMethod.GET)
    public Iterable<Tiers> sinistres() {
        return tiersRepository.getTiers();
    }

    @RequestMapping(value = "/tiers/{id}", method = RequestMethod.GET)
    public DeferredResult<Tiers> sinistre(@PathVariable Long id) {
        log.info("Appel de GET tiers avec id:{}", id);
        DeferredResult<Tiers> result = new DeferredResult<>();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        result.setResult(new Tiers(1L, "123", "Capraro", "Richard", "10/10/1974", new Adresse("Nimes", "4 rue Scatisse")));
        return result;
    }
}
