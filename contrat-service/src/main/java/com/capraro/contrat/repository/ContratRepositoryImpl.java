package com.capraro.contrat.repository;

import com.capraro.contrat.factory.ContratFactory;
import com.capraro.contrat.model.Contrat;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Fake Contrat Repository.
 * Created by Richard Capraro on 07/08/2015.
 */
@Repository
public class ContratRepositoryImpl implements ContratRepository {

    @Override
    public List<Contrat> getContrats() {

        return ContratFactory.getContrats();
    }
}
