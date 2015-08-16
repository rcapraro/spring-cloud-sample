package com.capraro.sinistre.factory;

import com.capraro.sinistre.model.Sinistre;
import com.capraro.sinistre.model.TypeSinistre;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Richard Capraro on 07/08/2015.
 */
public class SinistreFactory {

    private static List<Sinistre> SINISTRES = new ArrayList();

    static {

        Sinistre sinistre1 = Sinistre.builder()
                .id(1L)
                .numeroSinistre("1S004")
                .dateSurvenance(java.util.Date.from(Instant.now()))
                .montant(new BigDecimal("1000"))
                .type(TypeSinistre.CORPOREL)
                .build();

        SINISTRES.add(sinistre1);

    }

    public static List<Sinistre> getSinistres() {
        return SINISTRES;
    }
}
