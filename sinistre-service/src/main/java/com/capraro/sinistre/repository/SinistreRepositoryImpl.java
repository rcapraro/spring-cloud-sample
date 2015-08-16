package com.capraro.sinistre.repository;

import com.capraro.sinistre.factory.SinistreFactory;
import com.capraro.sinistre.model.Sinistre;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Fake Sinistre Repository.
 * Created by Richard Capraro on 07/08/2015.
 */
@Repository
public class SinistreRepositoryImpl implements SinistreRepository {

    @Override
    public List<Sinistre> getSinistres() {
        return SinistreFactory.getSinistres();
    }
}
