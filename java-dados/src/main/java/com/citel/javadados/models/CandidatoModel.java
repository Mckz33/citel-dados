package com.citel.javadados.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class CandidatoModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String cpf;
    @Column(nullable = false)
    private String rg;
    @Column(nullable = false)
    private String data_nasc;
    @Column(nullable = false)
    private String sexo;
    @Column(nullable = false)
    private String mae;
    @Column(nullable = false)
    private String pai;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String cep;
    @Column(nullable = false)
    private String endereco;
    @Column(nullable = false)
    private Integer numero;
    @Column(nullable = false)
    private String bairro;
    @Column(nullable = false)
    private String cidade;
    @Column(nullable = false)
    private String estado;
    @Column(nullable = false)
    private String telefone_fixo;
    @Column(nullable = false)
    private String celular;
    @Column(nullable = false)
    private Double altura;
    @Column(nullable = false)
    private Integer peso;
    @Column(nullable = false)
    private String tipo_sanguineo;

}
