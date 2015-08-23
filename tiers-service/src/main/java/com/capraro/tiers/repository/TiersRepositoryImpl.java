package com.capraro.tiers.repository;

import com.capraro.tiers.model.Tiers;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Fake Sinistre Repository.
 * Created by Richard Capraro on 07/08/2015.
 */
@Repository
public class TiersRepositoryImpl implements TiersRepository {

    @Override
    public List<Tiers> getTiers() {
        return null;
    }
}
