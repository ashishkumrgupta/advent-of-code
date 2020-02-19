package com.adventcode.solution.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * DTO class to hold name and quantity of a chemical.
 * 
 * @author ashis
 *
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Chemical {
	private String name;
	private long quantity;
}
