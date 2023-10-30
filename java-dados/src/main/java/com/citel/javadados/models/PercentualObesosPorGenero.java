package com.citel.javadados.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PercentualObesosPorGenero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double percentualObesosHomens;
    private Double percentualObesosMulheres;

    // Getters e setters
}