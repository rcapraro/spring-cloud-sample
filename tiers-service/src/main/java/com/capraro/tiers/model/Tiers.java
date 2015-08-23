package com.capraro.tiers.model;

import lombok.*;

/**
 * Classe représentant le tiers d'un contrat.
 * Created by Richard Capraro on 07/08/2015.
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Tiers {

    private Long id;

    private String numero;

    private String nom;

    private String prenom;

    private String dateNaissance;

    private Adresse adresse;
}
