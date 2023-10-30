package com.citel.javadados.models;

import java.io.Serializable;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonAlias;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "candidato_model")
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

    @Column(name = "data_nasc")
    @JsonAlias({ "nome", "data_nasc" })
    private String dataNasc;
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
    @Column(name = "telefone_fixo")
    @JsonAlias({ "nome", "telefone_fixo" })
    private String telefoneFixo;
    @Column(nullable = false)
    private String celular;
    @Column(nullable = false)
    private Double altura;
    @Column(nullable = false)
    private Integer peso;
    @Column(name = "tipo_sanguineo")
    @JsonAlias({ "nome", "tipo_sanguineo" })
    private String tipoSanguineo;

}
