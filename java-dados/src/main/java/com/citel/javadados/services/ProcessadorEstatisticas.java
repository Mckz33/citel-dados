package com.citel.javadados.services;

import java.util.List;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citel.javadados.dtos.Resposta;
import com.citel.javadados.models.CandidatoModel;

@Service
public class ProcessadorEstatisticas {

    private final List<Estatistica> estatisticas;

    @Autowired
    public ProcessadorEstatisticas(List<Estatistica> estatisticas) {
        this.estatisticas = estatisticas;
    }

    public Resposta processar(List<CandidatoModel> candidatos) {
        Resposta resposta = new Resposta();

        for (Estatistica estatistica : estatisticas) {
            Map<String, ?> resultado = estatistica.calcular(candidatos);
            resposta.adicionarResultado(estatistica.getClass().getSimpleName(), resultado);
        }

        return resposta;
    }
}