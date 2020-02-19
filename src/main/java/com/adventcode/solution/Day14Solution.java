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
	private static final String INPUT = "171 ORE => 8 CNZTR\r\n" + "7 ZLQW, 3 BMBT, 9 XCVML, 26 XMNCP, 1 WPTQ, 2 MZWV, 1 RJRHP => 4 PLWSL\r\n" + "114 ORE => 4 BHXH\r\n" + "14 VRPVC => 6 BMBT\r\n"
			+ "6 BHXH, 18 KTJDG, 12 WPTQ, 7 PLWSL, 31 FHTLT, 37 ZDVW => 1 FUEL\r\n" + "6 WPTQ, 2 BMBT, 8 ZLQW, 18 KTJDG, 1 XMNCP, 6 MZWV, 1 RJRHP => 6 FHTLT\r\n"
			+ "15 XDBXC, 2 LTCX, 1 VRPVC => 6 ZLQW\r\n" + "13 WPTQ, 10 LTCX, 3 RJRHP, 14 XMNCP, 2 MZWV, 1 ZLQW => 1 ZDVW\r\n" + "5 BMBT => 4 WPTQ\r\n" + "189 ORE => 9 KTJDG\r\n"
			+ "1 MZWV, 17 XDBXC, 3 XCVML => 2 XMNCP\r\n" + "12 VRPVC, 27 CNZTR => 2 XDBXC\r\n" + "15 KTJDG, 12 BHXH => 5 XCVML\r\n" + "3 BHXH, 2 VRPVC => 7 MZWV\r\n" + "121 ORE => 7 VRPVC\r\n"
			+ "7 XCVML => 6 RJRHP\r\n" + "5 BHXH, 4 VRPVC => 5 LTCX";

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

		System.out.println(day14Solution.calculateOneUnitOfFuelWithMemo(new Chemical("FUEL", 1), new HashMap<>()));
	}

	/**
	 * To calculate the total ORE required.
	 * 
	 * @param ingredient {@link Chemical}
	 * @param inventory
	 * @return total ore required.
	 */
	public long calculateOneUnitOfFuelWithMemo(Chemical ingredient, Map<String, Long> inventory) {
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
				long value = calculateOneUnitOfFuelWithMemo(new Chemical(reagent.getName(), reagentTotalQuantity), inventory);
				oreNeeded = oreNeeded + value;
			}

			long quantity = inventory.getOrDefault(ingredient.getName(), 0L);
			inventory.put(ingredient.getName(), quantity + reaction.getOuptut().getQuantity() * timesReaction - needed);
			return oreNeeded;
		}
	}
}
