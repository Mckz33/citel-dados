package com.citel.javadados.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.citel.javadados.models.CandidatoModel;

public interface CandidatoRepository extends JpaRepository<CandidatoModel, Long> {

    // List<CandidatoModel> findByNome(String nome);

    @Query("SELECT c FROM CandidatoModel c WHERE c.nome like %?1%")
    List<CandidatoModel> findByNome(@Param("nome")String nome);

}