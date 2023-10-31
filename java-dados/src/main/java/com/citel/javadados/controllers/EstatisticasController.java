/**
 * Esta classe é um controlador REST para gerar estatísticas com base nos dados dos candidatos.
 */
package com.citel.javadados.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citel.javadados.dtos.Resposta;
import com.citel.javadados.models.CandidatoModel;
import com.citel.javadados.services.CandidatoService;
import com.citel.javadados.services.ProcessadorEstatisticas;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/estatisticas")
public class EstatisticasController {

    private final ProcessadorEstatisticas processadorEstatisticas;

    @Autowired
    private CandidatoService candidatoService;
    
    /**
     * Construtor da classe EstatisticasController.
     *
     * @param processadorEstatisticas O processador de estatísticas a ser injetado.
     */
    @Autowired
    public EstatisticasController(ProcessadorEstatisticas processadorEstatisticas) {
        this.processadorEstatisticas = processadorEstatisticas;
    }

    /**
     * Gera estatísticas com base nos dados dos candidatos.
     *
     * @return Uma resposta contendo os resultados das estatísticas geradas.
     */
    @GetMapping("/gerar")
    public Resposta gerarEstatisticas() {
        // Aqui você deve obter a lista de candidatos que deseja processar, por exemplo, do seu serviço CandidatoService
        List<CandidatoModel> candidatos = candidatoService.findAll(); // Implemente o método getCandidatos()

        // Chame o processador de estatísticas para gerar as estatísticas
        return processadorEstatisticas.processar(candidatos);
    }

    // Implemente o método getCandidatos() para obter a lista de candidatos
}
