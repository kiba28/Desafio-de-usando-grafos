package com.desafiodev.utils;

import java.util.List;

import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.AllDirectedPaths;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;

import com.desafiodev.dto.AllPossiblePathsDTO;
import com.desafiodev.dto.GraphFormDTO;
import com.desafiodev.dto.ShortestDistanceDTO;
import com.desafiodev.entities.Graph;
import com.desafiodev.entities.Route;
import com.desafiodev.models.PossiblePath;

import lombok.Data;

@Data
public class GraphUtils {

	SimpleDirectedWeightedGraph<String, DefaultWeightedEdge> graph = new SimpleDirectedWeightedGraph<>(
			DefaultWeightedEdge.class);

	public GraphUtils(GraphFormDTO graphForm) {
		graphForm.getData().forEach(route -> {
			this.graph.addVertex(route.getSource());
			this.graph.addVertex(route.getTarget());
			this.addEdge(route.getSource(), route.getTarget(), route.getDistance());
		});
	}

	public Graph convertToGraph() {
		Graph graphEntity = new Graph();
		graph.edgeSet().forEach(edge -> {
			Route route = new Route(null, this.graph.getEdgeSource(edge), this.graph.getEdgeTarget(edge),
					(int) this.graph.getEdgeWeight(edge));
			graphEntity.getData().add(route);
		});
		return graphEntity;
	}

	public void addEdge(String town1, String town2, Integer weight) {
		DefaultWeightedEdge edge = graph.addEdge(town1, town2);
		if (edge != null) {
			graph.setEdgeWeight(edge, weight);
		}
	}

	public AllPossiblePathsDTO findAllPaths(String town1, String town2, Integer maxStops) {
		AllDirectedPaths<String, DefaultWeightedEdge> allPaths = new AllDirectedPaths<>(this.graph);
		List<GraphPath<String, DefaultWeightedEdge>> resultPaths = allPaths.getAllPaths(town1, town2, true, maxStops);
		AllPossiblePathsDTO allRoutes = new AllPossiblePathsDTO();

		resultPaths.forEach(path -> {
			String vertexPath = String.join("", path.getVertexList());
			PossiblePath route = new PossiblePath(vertexPath, path.getLength());
			allRoutes.getData().add(route);
		});

		return allRoutes;
	}

	public ShortestDistanceDTO findShortestPath(String town1, String town2) {
		if (town1.equals(town2)) {
			return new ShortestDistanceDTO(0);
		}
		GraphPath<String, DefaultWeightedEdge> graphPath = DijkstraShortestPath.findPathBetween(graph, town1, town2);

		if (graphPath == null) {
			return new ShortestDistanceDTO(-1);
		}
		return new ShortestDistanceDTO((int) graphPath.getWeight(), graphPath.getVertexList());
	}

}