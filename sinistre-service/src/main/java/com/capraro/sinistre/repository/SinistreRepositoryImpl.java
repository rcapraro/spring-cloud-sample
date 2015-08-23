package com.capraro.sinistre.repository;

import com.capraro.sinistre.model.Sinistre;
import io.github.benas.jpopulator.api.Populator;
import io.github.benas.jpopulator.impl.PopulatorBuilder;
import io.github.benas.jpopulator.randomizers.DateStringRandomizer;
import org.springframework.stereotype.Repository;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Fake Sinistre Repository.
 * Created by Richard Capraro on 07/08/2015.
 */
@Repository
public class SinistreRepositoryImpl implements SinistreRepository {

    final static DateFormat DF = new SimpleDateFormat("dd/mm/YYYY");
    static Populator POPULATOR;

    static {
        try {
            POPULATOR = new PopulatorBuilder()
                    .registerRandomizer(Sinistre.class, String.class, "dateSurvenance",
                            new DateStringRandomizer("dd/mm/YYYY", DF.parse("01/01/2000"), DF.parse("01/01/2016")))
                    .build();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<Sinistre> getSinistres() {

        List<Sinistre> sinistres = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            sinistres.add(generateRandomSinistre());
        }

        return sinistres;
    }


    @Override
    public Sinistre getSinistre() {
        return generateRandomSinistre();
    }

    private Sinistre generateRandomSinistre() {
        Sinistre contrat = POPULATOR.populateBean(Sinistre.class);
        return contrat;
    }
}
