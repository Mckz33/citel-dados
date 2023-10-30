package com.citel.javadados.services;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.citel.javadados.models.CandidatoModel;

public class EstatisticaPossiveisDoadoresPorTipoSanguineo implements Estatistica {

    @Override
    public Map<String, ?> calcular(List<CandidatoModel> candidatos) {
        return candidatos.stream()
                .filter(ElegibilidadeDoacao::isElegivelParaDoacao)
                .collect(Collectors.groupingBy(CandidatoModel::getTipoSanguineo, Collectors.counting()));
    }
}