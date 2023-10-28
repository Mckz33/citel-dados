package com.citel.javadados.controllers;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citel.javadados.dtos.CandidatoDto;
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
    public ResponseEntity<Object> save(@RequestBody @Valid CandidatoDto candidatoDto) {
        var candidatoModel = new CandidatoModel();
        BeanUtils.copyProperties(candidatoDto, candidatoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(candidatoService.save(candidatoModel));
    }

    @GetMapping
    public ResponseEntity<List<CandidatoModel>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(candidatoService.findAll());
    }

}
