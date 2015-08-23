package com.capraro.tiers.model;

import lombok.*;

/**
 * Classe Adresse.
 * Created by Richard Capraro on 23/08/2015.
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Adresse {

    private String ville;
    private String rue;

}
