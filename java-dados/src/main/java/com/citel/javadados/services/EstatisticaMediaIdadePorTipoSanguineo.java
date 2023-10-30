package com.citel.javadados.services;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.citel.javadados.models.CandidatoModel;

public class EstatisticaMediaIdadePorTipoSanguineo implements Estatistica {

    @Override
    public Map<String, Double> calcular(List<CandidatoModel> candidatos) {
        return candidatos.stream()
                .collect(Collectors.groupingBy(this::getFaixaEtaria,
                        Collectors.averagingDouble(this::getIdade))); // Modificado para Collectors.averagingDouble
    }

    private Double getIdade(CandidatoModel candidato) { // Alterado para retornar Double
        String dataNascimentoStr = candidato.getDataNasc();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataNascimento = LocalDate.parse(dataNascimentoStr, formatter);
        LocalDate dataAtual = LocalDate.now();

        Period periodo = Period.between(dataNascimento, dataAtual);
        int idade = periodo.getYears();

        if (dataAtual.getMonthValue() < dataNascimento.getMonthValue() ||
                (dataAtual.getMonthValue() == dataNascimento.getMonthValue() &&
                        dataAtual.getDayOfMonth() < dataNascimento.getDayOfMonth())) {
            idade--;
        }

        return (double) idade; // Convertendo a idade para Double
    }

    private String getFaixaEtaria(CandidatoModel candidato) {
        String dataNascimentoStr = candidato.getDataNasc();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataNascimento = LocalDate.parse(dataNascimentoStr, formatter);
        LocalDate dataAtual = LocalDate.now();

        Period periodo = Period.between(dataNascimento, dataAtual);
        int idade = periodo.getYears();

        if (dataAtual.getMonthValue() < dataNascimento.getMonthValue() ||
                (dataAtual.getMonthValue() == dataNascimento.getMonthValue() &&
                        dataAtual.getDayOfMonth() < dataNascimento.getDayOfMonth())) {
            idade--;
        }

        if (idade >= 0 && idade <= 14) {
            return "0-14 anos";
        } else if (idade >= 15 && idade <= 24) {
            return "15-24 anos";
        } else if (idade >= 25 && idade <= 34) {
            return "25-34 anos";
        } else if (idade >= 35 && idade <= 44) {
            return "35-44 anos";
        } else if (idade >= 45 && idade <= 54) {
            return "45-54 anos";
        } else if (idade >= 55 && idade <= 64) {
            return "55-64 anos";
        } else {
            return "65+ anos";
        }
    }
}
