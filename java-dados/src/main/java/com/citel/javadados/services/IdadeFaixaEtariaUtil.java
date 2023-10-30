package com.citel.javadados.services;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import com.citel.javadados.models.CandidatoModel;

public class IdadeFaixaEtariaUtil {
    
    public static int calcularIdade(String dataNascimentoStr) {
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

    public static String calcularFaixaEtaria(int idade) {
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

    public static int calcularIdade(CandidatoModel candidato) {
        return 0;
    }
}