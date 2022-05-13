package com.desafiodev.builders;

import java.util.Arrays;

import com.desafiodev.dto.GraphDTO;
import com.desafiodev.dto.GraphFormDTO;
import com.desafiodev.entities.Graph;

public class GraphBuilder {

	public static Graph getGraph() {
		Graph graph = new Graph();
		graph.setId(1L);
		graph.getData()
				.addAll(Arrays.asList(RouteBuilder.getRoute(), RouteBuilder.getRoute2(), RouteBuilder.getRoute3(),
						RouteBuilder.getRoute4(), RouteBuilder.getRoute5(), RouteBuilder.getRoute6(),
						RouteBuilder.getRoute7(), RouteBuilder.getRoute8(), RouteBuilder.getRoute9()));
		return graph;
	}

	public static GraphFormDTO getGraphFormDTO() {
		GraphFormDTO graphForm = new GraphFormDTO();
		graphForm.getData()
				.addAll(Arrays.asList(RouteBuilder.getRoute(), RouteBuilder.getRoute2(), RouteBuilder.getRoute3(),
						RouteBuilder.getRoute4(), RouteBuilder.getRoute5(), RouteBuilder.getRoute6(),
						RouteBuilder.getRoute7(), RouteBuilder.getRoute8(), RouteBuilder.getRoute9()));
		return graphForm;
	}

	public static GraphDTO getGraphDTO() {
		GraphDTO graphDto = new GraphDTO();
		graphDto.setId(1L);
		graphDto.getData()
				.addAll(Arrays.asList(RouteBuilder.getRoute(), RouteBuilder.getRoute2(), RouteBuilder.getRoute3(),
						RouteBuilder.getRoute4(), RouteBuilder.getRoute5(), RouteBuilder.getRoute6(),
						RouteBuilder.getRoute7(), RouteBuilder.getRoute8(), RouteBuilder.getRoute9()));
		return graphDto;
	}

}
