package com.citel.javadados.dtos;

import java.sql.Date;

import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Qualifier;

import com.fasterxml.jackson.annotation.JsonAlias;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CandidatoDto {

    @NotBlank
    private String nome;
    @NotBlank
    private String cpf;
    @NotBlank
    private String rg;

    @JsonAlias({"nome", "data_nasc"})
    private String dataNasc;
    @NotBlank
    private String sexo;
    @NotBlank
    private String mae;
    @NotBlank
    private String pai;
    @NotBlank
    private String email;
    @NotBlank
    private String cep;
    @NotBlank
    private String endereco;
    @NotNull
    private Integer numero;
    @NotBlank
    private String bairro;
    @NotBlank
    private String cidade;
    @NotBlank
    private String estado;
    
    @JsonAlias({"nome", "telefone_fixo"})
    private String telefoneFixo;

    @NotBlank
    private String celular;
    @NotNull
    private Double altura;
    @NotNull
    private Integer peso;
    
    @JsonAlias({"nome", "tipo_sanguineo"})
    private String tipoSanguineo;
}
