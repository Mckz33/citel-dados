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
public class EstatisticaIMCMedioPorFaixaEtaria implements Estatistica {

    @Override
    public Map<String, Double> calcular(List<CandidatoModel> candidatos) {
        return candidatos.stream()
            .collect(Collectors.groupingBy(this::getFaixaEtaria, 
                Collectors.averagingDouble(c -> c.getPeso() / Math.pow(c.getAltura(), 2))));
    }

    private String getFaixaEtaria(CandidatoModel candidato) {
        
            int idade = getIdade(candidato);
            if (idade <= 10)
                return "0-10";
            if (idade <= 20)
                return "11-20";
            if (idade <= 30)
                return "21-30";
            if (idade <= 40)
                return "31-40";
            if (idade <= 50)
                return "41-50";
            if (idade <= 60)
                return "51-60";
            if (idade <= 70)
                return "61-70";
            if (idade <= 80)
                return "71-80";
            if (idade <= 90)
                return "81-90";
            if (idade <= 100)
                return "91-100";
            
            return "100+";        
       
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
