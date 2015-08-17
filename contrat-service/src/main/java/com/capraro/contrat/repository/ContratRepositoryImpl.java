package com.capraro.contrat.repository;

import com.capraro.contrat.model.Client;
import com.capraro.contrat.model.Contrat;
import io.github.benas.jpopulator.api.Populator;
import io.github.benas.jpopulator.impl.PopulatorBuilder;
import io.github.benas.jpopulator.randomizers.DateStringRandomizer;
import io.github.benas.jpopulator.randomizers.FirstNameRandomizer;
import io.github.benas.jpopulator.randomizers.LastNameRandomizer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Fake Contrat Repository.
 * Created by Richard Capraro on 07/08/2015.
 */
@Repository
public class ContratRepositoryImpl implements ContratRepository {

    final static Populator POPULATOR = new PopulatorBuilder()
            .registerRandomizer(Client.class, String.class, "prenom", new FirstNameRandomizer())
            .registerRandomizer(Client.class, String.class, "nom", new LastNameRandomizer())
            .registerRandomizer(Contrat.class, String.class, "dateCreation", new DateStringRandomizer())
            .registerRandomizer(Contrat.class, String.class, "dateEffet", new DateStringRandomizer())
            .registerRandomizer(Client.class, String.class, "dateNaissance", new DateStringRandomizer())
            .build();

    @Override
    public List<Contrat> getContrats() {

        List<Contrat> contrats = new ArrayList<>();

        Populator populator = new PopulatorBuilder().build();

        for (int i = 0; i < 10; i++) {
            contrats.add(POPULATOR.populateBean(Contrat.class));
        }

        return contrats;
    }

    @Override
    public Contrat getContrat() {
        return POPULATOR.populateBean(Contrat.class);
    }
}
