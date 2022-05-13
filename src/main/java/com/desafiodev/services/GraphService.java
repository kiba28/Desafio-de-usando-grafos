package com.desafiodev.services;

import com.desafiodev.dto.AllPossiblePathsDTO;
import com.desafiodev.dto.ShortestDistanceDTO;
import com.desafiodev.dto.GraphDTO;
import com.desafiodev.dto.GraphFormDTO;

public interface GraphService {

	GraphDTO save(GraphFormDTO body);

	GraphDTO find(Long id);

	AllPossiblePathsDTO findAllAvailableRoutes(Long id, String source, String target, Integer maxStops);

	ShortestDistanceDTO findMinimumDistance(Long id, String source, String target);
}
