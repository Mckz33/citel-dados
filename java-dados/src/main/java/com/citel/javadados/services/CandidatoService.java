package com.citel.javadados.services;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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

    public List<CandidatoModel> saveAll(List<CandidatoModel> candidatos) {
       return candidatoRepository.saveAll(candidatos);
    }

}
