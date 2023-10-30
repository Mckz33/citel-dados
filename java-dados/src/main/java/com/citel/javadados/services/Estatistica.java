package com.citel.javadados.services;

import java.util.List;
import java.util.Map;

import com.citel.javadados.models.CandidatoModel;

public interface Estatistica {

    Map<String, ?> calcular(List<CandidatoModel> candidatos);
}
