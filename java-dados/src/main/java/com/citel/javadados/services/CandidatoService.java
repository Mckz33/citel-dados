package com.citel.javadados.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.citel.javadados.dtos.Resposta;
import com.citel.javadados.models.CandidatoModel;
import com.citel.javadados.repositories.CandidatoRepository;

import jakarta.transaction.Transactional;

@Service
public class CandidatoService {

    @Autowired
    public CandidatoRepository candidatoRepository;

    @Transactional
    public CandidatoModel save(CandidatoModel candidatoModel) {
        return candidatoRepository.save(candidatoModel);
    }

    public Page<CandidatoModel> findAll(Pageable pageable) {
        return candidatoRepository.findAll(pageable);
    }

    public Optional<CandidatoModel> findById(Long id) {
        return candidatoRepository.findById(id);
    }

    @Transactional
    public void delete(CandidatoModel parkingSpotModel) {
        candidatoRepository.delete(parkingSpotModel);
    }

    public Page<CandidatoModel> findByEstado(String estado, Pageable pageable) {
        return candidatoRepository.findByEstadoContaining(estado, pageable);
    }

    public Page<CandidatoModel> findByDataNasc(String dataNasc, Pageable pageable) {
        return candidatoRepository.findByDataNascContaining(dataNasc, pageable);
    }


    public Resposta processar(List<CandidatoModel> candidatos) {
        Resposta resposta = new Resposta();

        // 1. Candidatos por estado
        Map<String, Long> candidatosPorEstado = candidatos.stream()
            .collect(Collectors.groupingBy(CandidatoModel::getEstado, Collectors.counting()));
        resposta.setCandidatosPorEstado(candidatosPorEstado);

        // 2. IMC médio por faixa etária
        Map<String, Double> imcMedioPorFaixaEtaria = candidatos.stream()
            .collect(Collectors.groupingBy(this::getFaixaEtaria, 
                Collectors.averagingDouble(c -> c.getPeso() / Math.pow(c.getAltura(), 2))));
        resposta.setImcMedioPorFaixaEtaria(imcMedioPorFaixaEtaria);

        // 3. Percentual de obesos entre homens e mulheres
        long totalHomens = candidatos.stream().filter(c -> "Masculino".equals(c.getSexo())).count();
        long homensObesos = candidatos.stream().filter(c -> "Masculino".equals(c.getSexo()) 
            && c.getPeso() / Math.pow(c.getAltura(), 2) > 30).count();
        resposta.setPercentualObesosHomens(100.0 * homensObesos / totalHomens);

        long totalMulheres = candidatos.stream().filter(c -> "Feminino".equals(c.getSexo())).count();
        long mulheresObesas = candidatos.stream().filter(c -> "Feminino".equals(c.getSexo()) 
            && c.getPeso() / Math.pow(c.getAltura(), 2) > 30).count();
        resposta.setPercentualObesosMulheres(100.0 * mulheresObesas / totalMulheres);

        // 4. Média de idade por tipo sanguíneo
        Map<String, Double> mediaIdadePorTipoSanguineo = candidatos.stream()
            .collect(Collectors.groupingBy(CandidatoModel::getTipoSanguineo, 
                Collectors.averagingInt(this::getIdade)));
        resposta.setMediaIdadePorTipoSanguineo(mediaIdadePorTipoSanguineo);

        // 5. Possíveis doadores por tipo sanguíneo
        // Esta parte é mais complexa devido às regras de compatibilidade sanguínea e será simplificada aqui.
        // Você precisará implementar uma lógica mais completa para mapear os tipos sanguíneos dos doadores 
        // para os receptores.
        // Por simplicidade, esta implementação apenas conta candidatos elegíveis para doação (idade e peso).
        Map<String, Long> possiveisDoadoresPorTipoSanguineo = candidatos.stream()
            .filter(this::isElegivelParaDoacao)
            .collect(Collectors.groupingBy(CandidatoModel::getTipoSanguineo, Collectors.counting()));
        resposta.setPossiveisDoadoresPorTipoSanguineo(possiveisDoadoresPorTipoSanguineo);

        return resposta;
    }

    private String getFaixaEtaria(CandidatoModel candidato) {
        int idade = getIdade(candidato);
        if (idade <= 10) return "0-10";
        if (idade <= 20) return "11-20";
        if (idade <= 30) return "21-30";
        if (idade <= 40) return "31-40";
        if (idade <= 50) return "41-50";
        if (idade <= 60) return "51-60";
        if (idade <= 70) return "61-70";
        if (idade <= 80) return "71-80";
        if (idade <= 90) return "81-90";
        if (idade <= 100) return "91-100";
        //... e assim por diante para outras faixas etárias
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

    private boolean isElegivelParaDoacao(CandidatoModel candidato) {
        return getIdade(candidato) >= 16 && getIdade(candidato) <= 69 && candidato.getPeso() > 50;
    }

    

}
