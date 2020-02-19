package com.adventcode.solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.adventcode.solution.dto.Chemical;
import com.adventcode.solution.dto.Reaction;

/**
 * @author ashis
 *
 */
public class Day14Solution {
	private static final String INPUT = "10 ORE => 10 A\r\n" + 
			"1 ORE => 1 B\r\n" + 
			"7 A, 1 B => 1 C\r\n" + 
			"7 A, 1 C => 1 D\r\n" + 
			"7 A, 1 D => 1 E\r\n" + 
			"7 A, 1 E => 1 FUEL";

	private static final Map<String, Reaction> INPUT_IN_MAP = new HashMap<>();

	/**
	 * Constructor to load the Input data in to INPUT_IN_MAP
	 * 
	 * @param input
	 */
	public Day14Solution(String input) {
		Arrays.stream(input.split("\n")).map(splitSymbol -> splitSymbol.split("=>")).map(this::reaction).forEach(r -> INPUT_IN_MAP.put(r.getOuptut().getName(), r));
	}

	/**
	 * Method to process each line of input
	 * 
	 * @param line
	 * @return {@link Reaction}
	 */
	private Reaction reaction(String[] line) {
		List<Chemical> from = Arrays.stream(line[0].split(",")).map(String::trim).map(i -> ingredientOf(i.split(" "))).collect(Collectors.toList());
		Chemical to = ingredientOf(line[1].trim().split(" "));
		return new Reaction(from, to);
	}

	/**
	 * Method to process the line values and fill the {@link Chemical}
	 * 
	 * @param line
	 * @return {@link Chemical}
	 */
	private Chemical ingredientOf(String[] line) {
		return new Chemical(line[1], Integer.parseInt(line[0]));
	}

	public static void main(String[] args) {
		Day14Solution day14Solution = new Day14Solution(INPUT);

		System.out.println("Minimum amount of ORE required: " + day14Solution.calculateOneUnitOfFuel(new Chemical("FUEL", 1), new HashMap<>()));
		System.out.println("Maximum amount of FUEL can be produced : " + day14Solution.maximumAmountOfFuelProduced(1000000000000L));
	}

	/**
	 * To calculate the total ORE required.
	 * 
	 * @param ingredient {@link Chemical}
	 * @param inventory
	 * @return total ore required.
	 */
	public long calculateOneUnitOfFuel(Chemical ingredient, Map<String, Long> inventory) {
		if (ingredient.getName().equals("ORE")) {
			return ingredient.getQuantity();
		} else if (inventory.getOrDefault(ingredient.getName(), 0L) > ingredient.getQuantity()) {
			inventory.put(ingredient.getName(), inventory.get(ingredient.getName()) - ingredient.getQuantity());
			return 0;
		} else {
			long needed = ingredient.getQuantity() - inventory.getOrDefault(ingredient.getName(), 0L);
			inventory.remove(ingredient.getName());

			long oreNeeded = 0;
			Reaction reaction = INPUT_IN_MAP.get(ingredient.getName());
			long timesReaction = (long) Math.ceil(needed * 1.0 / reaction.getOuptut().getQuantity());
			for (Chemical reagent : reaction.getInputs()) {
				long reagentTotalQuantity = reagent.getQuantity() * timesReaction;
				long value = calculateOneUnitOfFuel(new Chemical(reagent.getName(), reagentTotalQuantity), inventory);
				oreNeeded = oreNeeded + value;
			}

			long quantity = inventory.getOrDefault(ingredient.getName(), 0L);
			inventory.put(ingredient.getName(), quantity + reaction.getOuptut().getQuantity() * timesReaction - needed);
			return oreNeeded;
		}
	}

	/**
	 * To calculate the maximum amount of fuel that can be produced with provided
	 * ORE.
	 * 
	 * @param cargoSize Maximum amount of cargo size.
	 * @return maximum amount of fuel that can be produced.
	 */
	public long maximumAmountOfFuelProduced(Long cargoSize) {
		long upperLimit = cargoSize;
		long lowerLimit = 0;
		long pivot = 0;
		while ((upperLimit - lowerLimit) > 1) {
			pivot = (lowerLimit + upperLimit) / 2;
			long oreNeeded = calculateOneUnitOfFuel(new Chemical("FUEL", pivot), new HashMap<>());
			if (oreNeeded <= cargoSize) {
				lowerLimit = pivot;
			} else {
				upperLimit = pivot;
			}
		}
		return Math.min(lowerLimit, pivot);
	}
}
