package com.citel.javadados.services;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.citel.javadados.models.CandidatoModel;

@Service
public class EstatisticaObesidadePorGenero implements Estatistica {

    @Override
    public Map<String, Double> calcular(List<CandidatoModel> candidatos) {
        long totalHomens = candidatos.stream().filter(c -> "Masculino".equals(c.getSexo())).count();
        long homensObesos = candidatos.stream().filter(c -> "Masculino".equals(c.getSexo())
                && c.getPeso() / Math.pow(c.getAltura(), 2) > 30).count();

        long totalMulheres = candidatos.stream().filter(c -> "Feminino".equals(c.getSexo())).count();
        long mulheresObesas = candidatos.stream().filter(c -> "Feminino".equals(c.getSexo())
                && c.getPeso() / Math.pow(c.getAltura(), 2) > 30).count();

        Map<String, Double> resultado = Map.of(
                "PercentualObesosHomens", 100.0 * homensObesos / totalHomens,
                "PercentualObesosMulheres", 100.0 * mulheresObesas / totalMulheres);

        return resultado;
    }

}
