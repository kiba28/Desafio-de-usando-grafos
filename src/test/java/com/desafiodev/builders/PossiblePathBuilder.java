package com.desafiodev.builders;

import java.util.Arrays;

import com.desafiodev.dto.AllPossiblePathsDTO;
import com.desafiodev.models.PossiblePath;

public class PossiblePathBuilder {

	public static PossiblePath getPossiblePath() {
		PossiblePath possiblePath = new PossiblePath("ABC", 2);
		return possiblePath;
	}

	public static PossiblePath getPossiblePath2() {
		PossiblePath possiblePath = new PossiblePath("ADC", 2);
		return possiblePath;
	}

	public static PossiblePath getPossiblePath3() {
		PossiblePath possiblePath = new PossiblePath("AEBC", 3);
		return possiblePath;
	}

	public static AllPossiblePathsDTO getAllPossiblePathsDTO() {
		AllPossiblePathsDTO allPossiblePathsDTO = new AllPossiblePathsDTO();
		allPossiblePathsDTO.getData().addAll(Arrays.asList(getPossiblePath(), getPossiblePath2(), getPossiblePath3()));
		return allPossiblePathsDTO;
	}

}
