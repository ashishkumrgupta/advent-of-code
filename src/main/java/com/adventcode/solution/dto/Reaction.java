package com.adventcode.solution.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * DTO class to store the information about input and output chemicals for a
 * reaction.
 * 
 * @author ashis
 *
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Reaction {
	private List<Chemical> inputs;
	private Chemical ouptut;
}
