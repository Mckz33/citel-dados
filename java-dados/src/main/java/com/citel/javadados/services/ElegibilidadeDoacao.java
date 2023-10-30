package com.citel.javadados.services;

import com.citel.javadados.models.CandidatoModel;

public class ElegibilidadeDoacao {
    public static boolean isElegivelParaDoacao(CandidatoModel candidato) {
        int idade = IdadeFaixaEtariaUtil.calcularIdade(candidato);

        // Verifica se a idade está entre 16 e 69 anos e o peso é maior que 50 kg
        return idade >= 16 && idade <= 69 && candidato.getPeso() > 50;
    }
}
