package com.citel.javadados.repositories;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.citel.javadados.models.CandidatoModel;

public interface CandidatoRepository extends JpaRepository<CandidatoModel, Long> {

    @Query("SELECT c FROM CandidatoModel c WHERE c.nome like %?1%")
    Page<CandidatoModel> findByNome(@Param("nome")String nome, Pageable pageable);

    

}