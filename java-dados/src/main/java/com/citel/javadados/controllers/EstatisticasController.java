package com.citel.javadados.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.citel.javadados.dtos.Resposta;
import com.citel.javadados.models.CandidatoModel;
import com.citel.javadados.services.CandidatoService;
import com.citel.javadados.services.ElegibilidadeDoacao;
import com.citel.javadados.services.EstatisticaIMCMedioPorFaixaEtaria;
import com.citel.javadados.services.EstatisticaMediaIdadePorTipoSanguineo;
import com.citel.javadados.services.EstatisticaObesidadePorGenero;
import com.citel.javadados.services.EstatisticaPorEstado;
import com.citel.javadados.services.EstatisticaPossiveisDoadoresPorTipoSanguineo;

@RestController
@RequestMapping("/api/estatisticas")
public class EstatisticasController {

    private final CandidatoService candidatoService;
    private final EstatisticaPorEstado estatisticaPorEstado;
    private final EstatisticaIMCMedioPorFaixaEtaria estatisticaIMCMedioPorFaixaEtaria;
    private final EstatisticaMediaIdadePorTipoSanguineo estatisticaMediaIdadePorTipoSanguineo;
    private final EstatisticaObesidadePorGenero estatisticaObesidadePorGenero;
    private final EstatisticaPossiveisDoadoresPorTipoSanguineo estatisticaPossiveisDoadoresPorTipoSanguineo;

    @Autowired
    public EstatisticasController(
            CandidatoService candidatoService,
            ElegibilidadeDoacao elegibilidadeDoacao,
            EstatisticaPorEstado estatisticaPorEstado,
            EstatisticaIMCMedioPorFaixaEtaria estatisticaIMCMedioPorFaixaEtaria,
            EstatisticaMediaIdadePorTipoSanguineo estatisticaMediaIdadePorTipoSanguineo,
            EstatisticaObesidadePorGenero estatisticaObesidadePorGenero,
            EstatisticaPossiveisDoadoresPorTipoSanguineo estatisticaPossiveisDoadoresPorTipoSanguineo) {
        this.candidatoService = candidatoService;
        this.estatisticaPorEstado = estatisticaPorEstado;
        this.estatisticaIMCMedioPorFaixaEtaria = estatisticaIMCMedioPorFaixaEtaria;
        this.estatisticaMediaIdadePorTipoSanguineo = estatisticaMediaIdadePorTipoSanguineo;
        this.estatisticaObesidadePorGenero = estatisticaObesidadePorGenero;
        this.estatisticaPossiveisDoadoresPorTipoSanguineo = estatisticaPossiveisDoadoresPorTipoSanguineo;
    }

    @GetMapping("/processarEstatisticas")
    public Resposta processarEstatisticas(@RequestParam("parametro1") String parametro1, @RequestParam("parametro2") String parametro2) {
        // Lógica para processar estatísticas com base nos parâmetros fornecidos
        // Use os serviços e classes de estatísticas para calcular as estatísticas
        // Retorne a resposta
        List<CandidatoModel> candidatos = candidatoService.obterCandidatos(); // Exemplo de como obter candidatos
        Resposta resposta = new Resposta();

        // 1. Estatísticas por estado
        Map<String, ?> estatisticasPorEstado = estatisticaPorEstado.calcular(candidatos);
        resposta.setCandidatosPorEstado(estatisticasPorEstado);

        // 2. IMC médio por faixa etária
        Map<String, ?> imcMedioPorFaixaEtaria = estatisticaIMCMedioPorFaixaEtaria.calcular(candidatos);
        resposta.setImcMedioPorFaixaEtaria(imcMedioPorFaixaEtaria);

        // 3. Percentual de obesos por gênero
        Map<String, ?> percentualObesosPorGenero = estatisticaObesidadePorGenero.calcular(candidatos);
        resposta.setPercentualObesosPorGenero(percentualObesosPorGenero);

        // 4. Média de idade por tipo sanguíneo
        Map<String, ?> mediaIdadePorTipoSanguineo = estatisticaMediaIdadePorTipoSanguineo.calcular(candidatos);
        resposta.setMediaIdadePorTipoSanguineo(mediaIdadePorTipoSanguineo);

        // 5. Possíveis doadores por tipo sanguíneo
        Map<String, ?> possiveisDoadoresPorTipoSanguineo = estatisticaPossiveisDoadoresPorTipoSanguineo.calcular(candidatos);
        resposta.setPossiveisDoadoresPorTipoSanguineo(possiveisDoadoresPorTipoSanguineo);

        return resposta;
    }
}