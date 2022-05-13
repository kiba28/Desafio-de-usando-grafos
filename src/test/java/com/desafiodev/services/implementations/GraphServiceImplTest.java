package com.desafiodev.services.implementations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.desafiodev.builders.GraphBuilder;
import com.desafiodev.builders.PossiblePathBuilder;
import com.desafiodev.builders.ShortestDistanceDtoBuilder;
import com.desafiodev.dto.AllPossiblePathsDTO;
import com.desafiodev.dto.GraphDTO;
import com.desafiodev.dto.GraphFormDTO;
import com.desafiodev.dto.ShortestDistanceDTO;
import com.desafiodev.entities.Graph;
import com.desafiodev.exceptions.DefaultException;
import com.desafiodev.respositories.GraphRepository;
import com.desafiodev.respositories.RouteRepository;
import com.desafiodev.services.GraphService;

@SpringBootTest
class GraphServiceImplTest {

	@Autowired
	private GraphService service;

	@MockBean
	private GraphRepository repository;

	@MockBean
	private RouteRepository routeRepository;

	@Test
	void ShoudSaveAGraph() {
		Graph graph = GraphBuilder.getGraph();
		GraphFormDTO graphFormDto = GraphBuilder.getGraphFormDTO();

		when(this.repository.save(any(Graph.class))).thenReturn(graph);

		GraphDTO graphDto = service.save(graphFormDto);

		assertThat(graphDto.getId()).isNotNull();
		assertThat(graphDto.getData()).isEqualTo(graph.getData());
	}

	@Test
	void shouldFindAGraphById() {
		Graph graph = GraphBuilder.getGraph();

		when(this.repository.findById(anyLong())).thenReturn(Optional.of(graph));

		GraphDTO graphDto = this.service.find(1L);

		assertThat(graphDto.getId()).isNotNull();
		assertThat(graphDto.getData()).isEqualTo(graph.getData());
	}

	@Test
	void shouldNotFindAGraphById() {
		when(this.repository.findById(anyLong())).thenReturn(Optional.empty());

		assertThatExceptionOfType(DefaultException.class).isThrownBy(() -> this.service.find(1L));
	}

	@Test
	void shouldFindAllAvailableRoutes() {
		Graph graph = GraphBuilder.getGraph();

		when(this.repository.findById(anyLong())).thenReturn(Optional.of(graph));

		AllPossiblePathsDTO allPossiblePathsDto = this.service.findAllAvailableRoutes(1L, "A", "C", 3);

		assertThat(allPossiblePathsDto.getData()).isNotNull();
		assertThat(allPossiblePathsDto.getData().get(0)).isEqualTo(PossiblePathBuilder.getPossiblePath());
	}

	@Test
	void shouldNotFindAllAvailableRoutesBecauseThereIsNoGraphWithThisId() {
		when(this.repository.findById(anyLong())).thenReturn(Optional.empty());

		assertThatExceptionOfType(DefaultException.class)
				.isThrownBy(() -> this.service.findAllAvailableRoutes(1L, "A", "C", null));
	}

	@Test
	void shouldFindMinimumDistance() {
		Graph graph = GraphBuilder.getGraph();
		ShortestDistanceDTO shortestDistanceDTO = ShortestDistanceDtoBuilder.getShortestDistanceDTO();

		when(this.repository.findById(anyLong())).thenReturn(Optional.of(graph));

		ShortestDistanceDTO shortestDitance = this.service.findMinimumDistance(1L, "A", "C");

		assertThat(shortestDitance).isEqualTo(shortestDistanceDTO);
		assertThat(shortestDitance.getDistance()).isEqualTo(shortestDistanceDTO.getDistance());
		assertThat(shortestDitance.getPath()).isEqualTo(shortestDistanceDTO.getPath());
	}

	@Test
	void shouldNotFindMinimumDistanceBecauseThereIsNoGraphWithThisId() {
		when(this.repository.findById(anyLong())).thenReturn(Optional.empty());

		assertThatExceptionOfType(DefaultException.class)
				.isThrownBy(() -> this.service.findMinimumDistance(1L, "A", "C"));
	}

}
