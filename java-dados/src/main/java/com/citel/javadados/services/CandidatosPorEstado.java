package com.citel.javadados.services;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.citel.javadados.models.CandidatoModel;

@Service
public class CandidatosPorEstado implements Estatistica {

	@Override
	public Map<String, ?> calcular(List<CandidatoModel> candidatos) {

		return candidatos.stream()
				.collect(Collectors.groupingBy(CandidatoModel::getEstado, Collectors.counting()));

	}

}
