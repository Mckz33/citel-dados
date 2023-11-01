package com.citel.javadados.services;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.citel.javadados.models.CandidatoModel;

@Service
public class EstatisticaMediaIdadePorTipoSanguineo implements Estatistica {

    @Override
    public Map<String, Double> calcular(List<CandidatoModel> candidatos) {

        Map<String, Double> mediaIdadePorTipoSanguineo = candidatos.stream()
                .collect(Collectors.groupingBy(CandidatoModel::getTipoSanguineo,
                        Collectors.averagingInt(this::getIdade)));
        return mediaIdadePorTipoSanguineo;
    }

    private int getIdade(CandidatoModel candidato) {

        // Data de nascimento no formato "dd/MM/yyyy"
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

        return idade;
    }

}