package com.capraro.contrat.model;

import lombok.Builder;
import lombok.Data;

/**
 * Classe représentant le risque du contrat.
 * Created by Richard Capraro on 07/08/2015.
 */
@Data
@Builder
public class Risque {

    private Long id;

    private String designation;

    private String adresse;
}
