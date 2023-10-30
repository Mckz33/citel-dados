package com.citel.javadados.models;

import java.util.Map;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class MediaIdadePorTipoSanguineo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Map<String, Double> mediaIdadePorTipoSanguineo;

    // Getters e setters
}