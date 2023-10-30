package com.citel.javadados.services;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.citel.javadados.models.CandidatoModel;

public class EstatisticaIMCMedioPorFaixaEtaria implements Estatistica {

    @Override
    public Map<String, Double> calcular(List<CandidatoModel> candidatos) {
        return candidatos.stream()
                .collect(Collectors.groupingBy(
                        c -> IdadeFaixaEtariaUtil
                                .calcularFaixaEtaria(IdadeFaixaEtariaUtil.calcularIdade(c.getDataNasc())),
                        Collectors.averagingDouble(c -> c.getPeso() / Math.pow(c.getAltura(), 2))));
    }
}
