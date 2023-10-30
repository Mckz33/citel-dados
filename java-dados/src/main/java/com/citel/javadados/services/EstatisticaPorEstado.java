package com.citel.javadados.services;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.citel.javadados.models.CandidatoModel;

public class EstatisticaPorEstado implements Estatistica {

    @Override
    public Map<String, Long> calcular(List<CandidatoModel> candidatos) {
        return candidatos.stream()
                .collect(Collectors.groupingBy(CandidatoModel::getEstado, Collectors.counting()));
    }
}
