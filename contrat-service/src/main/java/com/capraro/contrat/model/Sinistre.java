package com.capraro.contrat.model;

import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Réprésente un sinistre d'assurance simplifié.
 * Created by Richard Capraro on 07/08/2015.
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Sinistre {

    private Long id;

    private String numeroSinistre;

    private Date dateSurvenance;

    private BigDecimal montant;

    private TypeSinistre type;


}
