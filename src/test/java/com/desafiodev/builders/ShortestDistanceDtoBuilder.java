package com.desafiodev.builders;

import java.util.Arrays;

import com.desafiodev.dto.ShortestDistanceDTO;

public class ShortestDistanceDtoBuilder {

	public static ShortestDistanceDTO getShortestDistanceDTO() {
		ShortestDistanceDTO shortestDistanceDto = new ShortestDistanceDTO();
		shortestDistanceDto.setDistance(9);
		shortestDistanceDto.getPath().addAll(Arrays.asList("A", "B", "C"));
		return shortestDistanceDto;
	}

}
