package com.capraro.contrat.repository;

import com.capraro.contrat.model.Adresse;
import com.capraro.contrat.model.Contrat;
import com.capraro.contrat.model.Risque;
import com.capraro.contrat.model.Tiers;
import io.github.benas.jpopulator.api.Populator;
import io.github.benas.jpopulator.impl.PopulatorBuilder;
import io.github.benas.jpopulator.randomizers.*;
import org.springframework.stereotype.Repository;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Fake Contrat Repository.
 * Created by Richard Capraro on 07/08/2015.
 */
@Repository
public class ContratRepositoryImpl implements ContratRepository {

    final static DateFormat DF = new SimpleDateFormat("dd/mm/YYYY");
    static Populator POPULATOR;

    static {
        try {
            POPULATOR = new PopulatorBuilder()
                    .registerRandomizer(Tiers.class, String.class, "prenom", new FirstNameRandomizer())
                    .registerRandomizer(Tiers.class, String.class, "nom", new LastNameRandomizer())
                    .registerRandomizer(Contrat.class, String.class, "dateCreation",
                            new DateStringRandomizer("dd/mm/YYYY", DF.parse("01/01/2000"), DF.parse("01/01/2016")))
                    .registerRandomizer(Contrat.class, String.class, "dateEffet",
                            new DateStringRandomizer("dd/mm/YYYY", DF.parse("01/01/2000"), DF.parse("01/01/2016")))
                    .registerRandomizer(Tiers.class, String.class, "dateNaissance",
                            new DateStringRandomizer("dd/mm/YYYY", DF.parse("01/01/1930"), DF.parse("01/01/1998")))
                    .registerRandomizer(Adresse.class, String.class, "ville",
                            new CityRandomizer())
                    .registerRandomizer(Adresse.class, String.class, "rue",
                            new StreetRandomizer())
                    .build();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Contrat> getContrats() {

        List<Contrat> contrats = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            contrats.add(generateRandomContrat());
        }

        return contrats;
    }


    @Override
    public Contrat getContrat() {
        return generateRandomContrat();
    }

    private Contrat generateRandomContrat() {
        Contrat contrat = POPULATOR.populateBean(Contrat.class);
        Tiers client = POPULATOR.populateBean(Tiers.class);
        Adresse adresseClient = POPULATOR.populateBean(Adresse.class);
        Adresse adresseRisque = POPULATOR.populateBean(Adresse.class);
        Risque risque = POPULATOR.populateBean(Risque.class);
        client.setAdresse(adresseClient);
        risque.setAdresse(adresseRisque);
        contrat.setTiers(client);
        contrat.setRisque(risque);
        return contrat;
    }

}
