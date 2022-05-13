package com.desafiodev.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShortestDistanceDTO {

	private int distance;
	private List<String> path = new ArrayList<>();

	public ShortestDistanceDTO(int distance) {
		this.distance = distance;
	}

}
