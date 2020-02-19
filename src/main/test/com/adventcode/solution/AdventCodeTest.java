package com.adventcode.solution;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Test;

import com.adventcode.solution.dto.Chemical;

public class AdventCodeTest {

	@Test
	public void testCase1() {
		Day14Solution unitToTest = new Day14Solution("10 ORE => 10 A\r\n" + "1 ORE => 1 B\r\n" + "7 A, 1 B => 1 C\r\n" + "7 A, 1 C => 1 D\r\n" + "7 A, 1 D => 1 E\r\n" + "7 A, 1 E => 1 FUEL");

		long result = unitToTest.calculateOneUnitOfFuelWithMemo(new Chemical("FUEL", 1), new HashMap<>());

		assertEquals(31, result);
	}

	@Test
	public void testCase2() {
		Day14Solution unitToTest = new Day14Solution(
				"9 ORE => 2 A\r\n" + "8 ORE => 3 B\r\n" + "7 ORE => 5 C\r\n" + "3 A, 4 B => 1 AB\r\n" + "5 B, 7 C => 1 BC\r\n" + "4 C, 1 A => 1 CA\r\n" + "2 AB, 3 BC, 4 CA => 1 FUEL");

		long result = unitToTest.calculateOneUnitOfFuelWithMemo(new Chemical("FUEL", 1), new HashMap<>());

		assertEquals(165, result);
	}

	@Test
	public void testCase3() {
		Day14Solution unitToTest = new Day14Solution("171 ORE => 8 CNZTR\r\n" + "7 ZLQW, 3 BMBT, 9 XCVML, 26 XMNCP, 1 WPTQ, 2 MZWV, 1 RJRHP => 4 PLWSL\r\n" + "114 ORE => 4 BHXH\r\n"
				+ "14 VRPVC => 6 BMBT\r\n" + "6 BHXH, 18 KTJDG, 12 WPTQ, 7 PLWSL, 31 FHTLT, 37 ZDVW => 1 FUEL\r\n" + "6 WPTQ, 2 BMBT, 8 ZLQW, 18 KTJDG, 1 XMNCP, 6 MZWV, 1 RJRHP => 6 FHTLT\r\n"
				+ "15 XDBXC, 2 LTCX, 1 VRPVC => 6 ZLQW\r\n" + "13 WPTQ, 10 LTCX, 3 RJRHP, 14 XMNCP, 2 MZWV, 1 ZLQW => 1 ZDVW\r\n" + "5 BMBT => 4 WPTQ\r\n" + "189 ORE => 9 KTJDG\r\n"
				+ "1 MZWV, 17 XDBXC, 3 XCVML => 2 XMNCP\r\n" + "12 VRPVC, 27 CNZTR => 2 XDBXC\r\n" + "15 KTJDG, 12 BHXH => 5 XCVML\r\n" + "3 BHXH, 2 VRPVC => 7 MZWV\r\n" + "121 ORE => 7 VRPVC\r\n"
				+ "7 XCVML => 6 RJRHP\r\n" + "5 BHXH, 4 VRPVC => 5 LTCX");

		long result = unitToTest.calculateOneUnitOfFuelWithMemo(new Chemical("FUEL", 1), new HashMap<>());

		assertEquals(2210736, result);
	}

	@Test
	public void testCase4() {
		Day14Solution unitToTest = new Day14Solution(
				"2 VPVL, 7 FWMGM, 2 CXFTF, 11 MNCFX => 1 STKFG\r\n" + "17 NVRVD, 3 JNWZP => 8 VPVL\r\n" + "53 STKFG, 6 MNCFX, 46 VJHF, 81 HVMC, 68 CXFTF, 25 GNMV => 1 FUEL\r\n"
						+ "22 VJHF, 37 MNCFX => 5 FWMGM\r\n" + "139 ORE => 4 NVRVD\r\n" + "144 ORE => 7 JNWZP\r\n" + "5 MNCFX, 7 RFSQX, 2 FWMGM, 2 VPVL, 19 CXFTF => 3 HVMC\r\n"
						+ "5 VJHF, 7 MNCFX, 9 VPVL, 37 CXFTF => 6 GNMV\r\n" + "145 ORE => 6 MNCFX\r\n" + "1 NVRVD => 8 CXFTF\r\n" + "1 VJHF, 6 MNCFX => 4 RFSQX\r\n" + "176 ORE => 6 VJHF");

		long result = unitToTest.calculateOneUnitOfFuelWithMemo(new Chemical("FUEL", 1), new HashMap<>());

		assertEquals(180697, result);
	}
}
