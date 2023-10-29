package com.citel.javadados.repositories;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.citel.javadados.models.CandidatoModel;

public interface CandidatoRepository extends JpaRepository<CandidatoModel, Long> {

    Page<CandidatoModel> findByEstadoContaining(String estado, Pageable pageable);

    Page<CandidatoModel> findByDataNascContaining(String dataNasc, Pageable pageable);

    // @Query("SELECT c FROM CandidatoModel c WHERE c.estado like %?1%")
    // Page<CandidatoModel> findByEstado(@Param("estado") String estado, Pageable pageable);

    // @Query("SELECT c FROM CandidatoModel c WHERE c.data_nasc like %?1%")
    // Page<CandidatoModel> findByDataNascPage(@Param("data_nasc")Date dateNasc,
    // Pageable pageable);

}