package com.citel.javadados.dtos;

import java.util.Map;

import lombok.Data;

@Data
public class Resposta {
    private Map<String, ?> candidatosPorEstado;
    private Map<String, ?> imcMedioPorFaixaEtaria;
    private double percentualObesosHomens;
    private double percentualObesosMulheres;
    private Map<String, ?> mediaIdadePorTipoSanguineo;
    private Map<String, Long> possiveisDoadoresPorTipoSanguineo;


    public Map<String, ?> getCandidatosPorEstado() {
        return candidatosPorEstado;
    }

    public void setCandidatosPorEstado(Map<String, ?> estatisticasPorEstado) {
        this.candidatosPorEstado = estatisticasPorEstado;
    }

    public Map<String, ?> getImcMedioPorFaixaEtaria() {
        return imcMedioPorFaixaEtaria;
    }

    public void setImcMedioPorFaixaEtaria(Map<String, ?> imcMedioPorFaixaEtaria2) {
        this.imcMedioPorFaixaEtaria = imcMedioPorFaixaEtaria2;
    }

    public double getPercentualObesosHomens() {
        return percentualObesosHomens;
    }

    public void setPercentualObesosHomens(double percentualObesosHomens) {
        this.percentualObesosHomens = percentualObesosHomens;
    }

    public double getPercentualObesosMulheres() {
        return percentualObesosMulheres;
    }

    public void setPercentualObesosMulheres(double percentualObesosMulheres) {
        this.percentualObesosMulheres = percentualObesosMulheres;
    }

    public Map<String, ?> getMediaIdadePorTipoSanguineo() {
        return mediaIdadePorTipoSanguineo;
    }

    public void setMediaIdadePorTipoSanguineo(Map<String, ?> mediaIdadePorTipoSanguineo2) {
        this.mediaIdadePorTipoSanguineo = mediaIdadePorTipoSanguineo2;
    }

    public Map<String, Long> getPossiveisDoadoresPorTipoSanguineo() {
        return possiveisDoadoresPorTipoSanguineo;
    }

    public void setPossiveisDoadoresPorTipoSanguineo(Map<String, ?> possiveisDoadoresPorTipoSanguineo2) {
        this.possiveisDoadoresPorTipoSanguineo = (Map<String, Long>) possiveisDoadoresPorTipoSanguineo2;
    }

    public void setPercentualObesosPorGenero(Map<String, ?> percentualObesosPorGenero) {
    }
}