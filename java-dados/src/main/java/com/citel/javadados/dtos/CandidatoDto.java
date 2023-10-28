package com.citel.javadados.dtos;

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
    @NotBlank
    private String data_nasc;
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
    @NotBlank
    private String telefone_fixo;
    @NotBlank
    private String celular;
    @NotNull
    private Double altura;
    @NotNull
    private Integer peso;
    @NotBlank
    private String tipo_sanguineo;
}
