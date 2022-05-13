package com.desafiodev.dto;

import java.util.ArrayList;
import java.util.List;

import com.desafiodev.models.PossiblePath;

import lombok.Data;

@Data
public class AllPossiblePathsDTO {

	private List<PossiblePath> data = new ArrayList<>();

}
