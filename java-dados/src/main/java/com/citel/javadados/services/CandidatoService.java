package com.citel.javadados.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.citel.javadados.dtos.Resposta;
import com.citel.javadados.models.CandidatoModel;
import com.citel.javadados.repositories.CandidatoRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

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

    public Resposta processar(@Valid List<CandidatoModel> candidatoDto) {
        return null;
    }

    public List<CandidatoModel> obterCandidatos() {
        return null;
    }
}
