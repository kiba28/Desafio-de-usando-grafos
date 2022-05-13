package com.desafiodev.services.implementations;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafiodev.dto.AllPossiblePathsDTO;
import com.desafiodev.dto.GraphDTO;
import com.desafiodev.dto.GraphFormDTO;
import com.desafiodev.dto.ShortestDistanceDTO;
import com.desafiodev.entities.Graph;
import com.desafiodev.exceptions.DefaultException;
import com.desafiodev.respositories.GraphRepository;
import com.desafiodev.respositories.RouteRepository;
import com.desafiodev.services.GraphService;
import com.desafiodev.utils.GraphUtils;

@Service
public class GraphServiceImpl implements GraphService {

	@Autowired
	private GraphRepository repository;

	@Autowired
	private RouteRepository routeRepository;

	@Autowired
	private ModelMapper mapper;

	@Override
	public GraphDTO save(GraphFormDTO body) {

		GraphUtils jGraphT = new GraphUtils(body);
		Graph graph = jGraphT.convertToGraph();
		graph.getData().forEach(routeRepository::save);

		return mapper.map(repository.save(graph), GraphDTO.class);
	}

	@Override
	public GraphDTO find(Long id) {

		Graph resultGraph = repository.findById(id).orElseThrow(() -> throwDefaultException(id));

		return mapper.map(resultGraph, GraphDTO.class);
	}

	@Override
	public AllPossiblePathsDTO findAllAvailableRoutes(Long id, String source, String target, Integer maxStops) {

		Graph resultGraph = repository.findById(id).orElseThrow(() -> throwDefaultException(id));

		GraphUtils jGraphT = new GraphUtils(mapper.map(resultGraph, GraphFormDTO.class));

		return jGraphT.findAllPaths(source, target, maxStops);
	}

	@Override
	public ShortestDistanceDTO findMinimumDistance(Long id, String source, String target) {

		Graph resultGraph = repository.findById(id).orElseThrow(() -> throwDefaultException(id));

		GraphUtils jGraphT = new GraphUtils(mapper.map(resultGraph, GraphFormDTO.class));

		return jGraphT.findShortestPath(source, target);
	}

	private DefaultException throwDefaultException(Long id) {
		return new DefaultException(404, "NOT_FOUND", "Graph with id = " + id + " not found");
	}

}
