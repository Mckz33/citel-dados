/**
 * Esta classe é um controlador REST para lidar com operações relacionadas a candidatos e cálculo de IMC.
 */
package com.citel.javadados.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.citel.javadados.dtos.Resposta;
import com.citel.javadados.models.CandidatoModel;
import com.citel.javadados.services.CandidatoService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/candidato")
public class CandidatoController {

    @Autowired
    public CandidatoService candidatoService;

    /**
     * Cria um novo registro de candidato ou candidatos e calcula estatísticas de IMC.
     *
     * @param candidatoDto A lista de candidatos a serem criados.
     * @return Uma resposta contendo os resultados das estatísticas de IMC calculadas.
     */
    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid List<CandidatoModel> candidatoDto) {
         candidatoService.saveAll(candidatoDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * Cria um novo registro de candidato ou candidatos e calcula estatísticas de IMC, salvando os candidatos no banco de dados.
     *
     * @param candidatoDto A lista de candidatos a serem criados.
     * @return Uma resposta contendo os resultados das estatísticas de IMC calculadas.
     */
    @PostMapping("/save-all")
    public ResponseEntity<Object> saveAll(@RequestBody @Valid List<CandidatoModel> candidatoDto) {
    	candidatoService.saveAll(candidatoDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * Obtém uma página de candidatos.
     *
     * @param pageable As opções de paginação.
     * @return Uma página de candidatos.
     */
    @GetMapping
    public ResponseEntity<Page<CandidatoModel>> getAll(Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(candidatoService.findAllPage(pageable));
    }

    /**
     * Obtém um candidato pelo ID.
     *
     * @param id O ID do candidato a ser obtido.
     * @return O candidato com o ID correspondente, se existir.
     */
    @GetMapping("/{id}")
    public Optional<CandidatoModel> findById(@PathVariable Long id) {
        return candidatoService.findById(id);
    }

    /**
     * Pesquisa candidatos por estado.
     *
     * @param estado O estado a ser pesquisado.
     * @param pageable As opções de paginação.
     * @return Uma página de candidatos do estado especificado.
     */
    @GetMapping("/pesquisar-estado/{estado}")
    public ResponseEntity<Page<CandidatoModel>> findByEstado(@PathVariable String estado, Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(candidatoService.findByEstado(estado, pageable));
    }
    
    @DeleteMapping
    public ResponseEntity<Page<CandidatoModel>> deleteAll() {
    	candidatoService.deleteAll();
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
