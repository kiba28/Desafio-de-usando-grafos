package com.desafiodev.dto;

import java.util.List;

import com.desafiodev.entities.Route;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GraphDTO {

	private Long id;
	private List<Route> data;

}
