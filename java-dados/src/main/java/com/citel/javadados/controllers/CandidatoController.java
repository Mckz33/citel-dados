package com.citel.javadados.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@RequestMapping("/imc")
public class CandidatoController {

    @Autowired
    public CandidatoService candidatoService;

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid List<CandidatoModel> candidatoDto) {
        // List<CandidatoModel> candidatoModel = new ArrayList<CandidatoModel >();
        /// List<CandidatoModel> candidatoModelt = new ArrayList<CandidatoModel>();
        // BeanUtils.copyProperties(candidatoDto, candidatoModel);
        /// candidatoModelt.addAll(candidatoModel);
        Resposta resposta = candidatoService.processar(candidatoDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(resposta);
    }
    @PostMapping("/save-all")
    public ResponseEntity<Object> saveAll(@RequestBody @Valid List<CandidatoModel> candidatoDto) {
        // List<CandidatoModel> candidatoModel = new ArrayList<CandidatoModel >();
        /// List<CandidatoModel> candidatoModelt = new ArrayList<CandidatoModel>();
        // BeanUtils.copyProperties(candidatoDto, candidatoModel);
        /// candidatoModelt.addAll(candidatoModel);
        Resposta resposta = candidatoService.processar(candidatoDto);
        candidatoService.saveAll(candidatoDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(resposta);
    }

    @GetMapping
    public ResponseEntity<Page<CandidatoModel>> getAll(Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(candidatoService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public Optional<CandidatoModel> findById(@PathVariable Long id) {
        return candidatoService.findById(id);
    }

    @GetMapping("/pesquisar-estado/{estado}")
    public ResponseEntity<Page<CandidatoModel>> findByEstado(@PathVariable String estado, Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(candidatoService.findByEstado(estado, pageable));
    }
}
