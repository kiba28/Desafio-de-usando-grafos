package com.desafiodev.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import com.desafiodev.entities.Route;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GraphFormDTO {

	@NotEmpty(message = "Graph cannot be empty.")
	private List<Route> data = new ArrayList<>();

}
