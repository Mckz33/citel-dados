package com.citel.javadados.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citel.javadados.models.CandidatoModel;

public interface CandidatoRepository extends JpaRepository<CandidatoModel, Long> {

}
