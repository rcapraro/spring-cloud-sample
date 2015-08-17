package com.capraro.sinistre.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Réprésente un sinistre d'assurance simplifié.
 * Created by Richard Capraro on 07/08/2015.
 */
@Data
@Builder
public class Sinistre {

    private Long id;

    private String numeroSinistre;

    private String dateSurvenance;

    private BigDecimal montant;

    private TypeSinistre type;


}
