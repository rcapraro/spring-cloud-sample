package com.capraro.contrat.model;

import lombok.*;

/**
 * Classe représentant le risque du contrat.
 * Created by Richard Capraro on 07/08/2015.
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Risque {

    private Long id;

    private String designation;

    private String adresse;
}
