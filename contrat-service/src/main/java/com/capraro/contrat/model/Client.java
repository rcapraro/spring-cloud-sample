package com.capraro.contrat.model;

import lombok.*;

/**
 * Classe représentant le client d'un contrat.
 * Created by Richard Capraro on 07/08/2015.
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Client {

    private Long id;

    private String numero;

    private String nom;

    private String prenom;

    private String dateNaissance;

    private String adresse;
}
