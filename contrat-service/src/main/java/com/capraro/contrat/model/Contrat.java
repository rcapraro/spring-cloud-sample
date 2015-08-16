package com.capraro.contrat.model;

import lombok.*;

import java.util.Date;
import java.util.List;

/**
 * Classe Contrat simplifiée.
 * Created by Richard Capraro on 07/08/2015.
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Contrat {

    private Long id;

    private String numero;

    private Date DateCreation;

    private Date DateEffet;

    private Produit produit;

    private Client client;

    private Risque risque;

    private List<Sinistre> sinistres;


}
