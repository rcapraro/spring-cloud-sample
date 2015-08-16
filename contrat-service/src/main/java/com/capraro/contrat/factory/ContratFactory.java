package com.capraro.contrat.factory;

import com.capraro.contrat.model.Client;
import com.capraro.contrat.model.Contrat;

import java.sql.Date;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Richard Capraro on 07/08/2015.
 */
public class ContratFactory {

    private static List<Contrat> CONTRATS = new ArrayList();

    static {

        Contrat contrat1 = Contrat.builder()
                .id(1L)
                .client(Client.builder()
                        .id(1L)
                        .adresse("20 rue de la république")
                        .dateNaissance(Date.from(Instant.now()))
                        .nom("Martin")
                        .prenom("Serge")
                        .numero("456B")
                        .build()
                        ).build();


        CONTRATS.add(contrat1);


    }

    public static List<Contrat> getContrats() {
        return CONTRATS;
    }
}
