package com.desafiodev.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.desafiodev.dto.AllPossiblePathsDTO;
import com.desafiodev.dto.GraphDTO;
import com.desafiodev.dto.GraphFormDTO;
import com.desafiodev.dto.ShortestDistanceDTO;
import com.desafiodev.services.GraphService;

@RestController
public class GraphController {

	@Autowired
	private GraphService service;

	@PostMapping(value = "/graph")
	public ResponseEntity<GraphDTO> saveGraph(@RequestBody GraphFormDTO body) {
		GraphDTO graphDto = this.service.save(body);

		return ResponseEntity.status(HttpStatus.CREATED).body(graphDto);
	}

	@GetMapping(value = "/graph/{id}")
	public ResponseEntity<GraphDTO> findGraph(@PathVariable Long id) {
		GraphDTO graphDto = this.service.find(id);

		return ResponseEntity.status(HttpStatus.OK).body(graphDto);
	}

	@PostMapping(value = "routes/{graphId}/from/{town1}/to/{town2}")
	public ResponseEntity<AllPossiblePathsDTO> findAllAvailableRoutes(@PathVariable(name = "graphId") Long id,
			@PathVariable(name = "town1") String source, @PathVariable(name = "town2") String target,
			@RequestParam(required = false) Integer maxStops) {

		AllPossiblePathsDTO possibleRoutesDto = this.service.findAllAvailableRoutes(id, source, target, maxStops);

		return ResponseEntity.status(HttpStatus.OK).body(possibleRoutesDto);
	}

	@PostMapping(value = "/distance/{graphId}/from/{town1}/to/{town2}")
	public ResponseEntity<ShortestDistanceDTO> findMinimumDistance(@PathVariable(name = "graphId") Long id,
			@PathVariable(name = "town1") String source, @PathVariable(name = "town2") String target) {

		ShortestDistanceDTO distanceDto = this.service.findMinimumDistance(id, source, target);

		return ResponseEntity.status(HttpStatus.OK).body(distanceDto);
	}

}
