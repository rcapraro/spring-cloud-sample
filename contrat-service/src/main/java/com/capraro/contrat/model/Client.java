package com.capraro.contrat.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * Classe représentant le client d'un contrat.
 * Created by Richard Capraro on 07/08/2015.
 */
@Data
@Builder
public class Client {

    private Long id;

    private String numero;

    private String nom;

    private String prenom;

    private Date dateNaissance;

    private String adresse;
}
