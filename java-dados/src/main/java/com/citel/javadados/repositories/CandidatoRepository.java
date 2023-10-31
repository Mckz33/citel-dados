/**
 * Esta interface define o repositório para a entidade CandidatoModel, permitindo operações de acesso aos dados relacionados aos candidatos.
 */
package com.citel.javadados.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.citel.javadados.models.CandidatoModel;

public interface CandidatoRepository extends JpaRepository<CandidatoModel, Long> {

    /**
     * Encontra uma página de candidatos com base no estado fornecido.
     *
     * @param estado   O estado a ser pesquisado.
     * @param pageable As opções de paginação.
     * @return Uma página de candidatos do estado especificado.
     */
    Page<CandidatoModel> findByEstadoContaining(String estado, Pageable pageable);

    /**
     * Encontra uma página de candidatos com base na data de nascimento fornecida.
     *
     * @param dataNasc A data de nascimento a ser pesquisada.
     * @param pageable As opções de paginação.
     * @return Uma página de candidatos com a data de nascimento especificada.
     */
    Page<CandidatoModel> findByDataNascContaining(String dataNasc, Pageable pageable);
}
