package com.citel.javadados.services;

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

    public Page<CandidatoModel> findAllPage(Pageable pageable) {
        return candidatoRepository.findAll(pageable);
    }

    public List<CandidatoModel> findAll() {
        return candidatoRepository.findAll();
    }

    public Optional<CandidatoModel> findById(Long id) {
        return candidatoRepository.findById(id);
    }

    @Transactional
    public void deleteAll() {
        candidatoRepository.deleteAll();
    }

    public Page<CandidatoModel> findByEstado(String estado, Pageable pageable) {
        return candidatoRepository.findByEstadoContaining(estado, pageable);
    }

    public Page<CandidatoModel> findByDataNasc(String dataNasc, Pageable pageable) {
        return candidatoRepository.findByDataNascContaining(dataNasc, pageable);
    }

    public void saveAll(List<CandidatoModel> candidatos) {
        candidatoRepository.saveAll(candidatos);
    }   
    

}
