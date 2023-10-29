package com.citel.javadados.dtos;

import java.util.Map;

import lombok.Data;

@Data
public class Resposta {
    private Map<String, Long> candidatosPorEstado;
    private Map<String, Double> imcMedioPorFaixaEtaria;
    private double percentualObesosHomens;
    private double percentualObesosMulheres;
    private Map<String, Double> mediaIdadePorTipoSanguineo;
    private Map<String, Long> possiveisDoadoresPorTipoSanguineo;

}