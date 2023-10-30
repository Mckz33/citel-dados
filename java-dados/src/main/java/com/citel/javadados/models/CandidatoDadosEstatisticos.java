package com.citel.javadados.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "candidados_estatisticas")
public class CandidatoDadosEstatisticos {
    private String estado;
    private String sexo;
    private double peso;
    private double altura;
    private String tipoSanguineo;
}
