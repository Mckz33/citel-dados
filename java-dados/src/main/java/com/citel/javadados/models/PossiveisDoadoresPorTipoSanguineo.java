package com.citel.javadados.models;

import java.util.Map;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PossiveisDoadoresPorTipoSanguineo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Map<String, Long> possiveisDoadoresPorTipoSanguineo;

    // Getters e setters
}