package com.adventcode.solution;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import com.adventcode.solution.dto.Chemical;

public class AdventCodeTest {

	private String testInput1;
	private String testInput2;
	private String testInput3;
	private String testInput4;
	private String testInput5;

	@Before
	public void setup() {
		this.testInput1 = "10 ORE => 10 A\r\n" + "1 ORE => 1 B\r\n" + "7 A, 1 B => 1 C\r\n" + "7 A, 1 C => 1 D\r\n" + "7 A, 1 D => 1 E\r\n" + "7 A, 1 E => 1 FUEL";

		this.testInput2 = "9 ORE => 2 A\r\n" + "8 ORE => 3 B\r\n" + "7 ORE => 5 C\r\n" + "3 A, 4 B => 1 AB\r\n" + "5 B, 7 C => 1 BC\r\n" + "4 C, 1 A => 1 CA\r\n" + "2 AB, 3 BC, 4 CA => 1 FUEL";

		this.testInput3 = "171 ORE => 8 CNZTR\r\n" + "7 ZLQW, 3 BMBT, 9 XCVML, 26 XMNCP, 1 WPTQ, 2 MZWV, 1 RJRHP => 4 PLWSL\r\n" + "114 ORE => 4 BHXH\r\n" + "14 VRPVC => 6 BMBT\r\n"
				+ "6 BHXH, 18 KTJDG, 12 WPTQ, 7 PLWSL, 31 FHTLT, 37 ZDVW => 1 FUEL\r\n" + "6 WPTQ, 2 BMBT, 8 ZLQW, 18 KTJDG, 1 XMNCP, 6 MZWV, 1 RJRHP => 6 FHTLT\r\n"
				+ "15 XDBXC, 2 LTCX, 1 VRPVC => 6 ZLQW\r\n" + "13 WPTQ, 10 LTCX, 3 RJRHP, 14 XMNCP, 2 MZWV, 1 ZLQW => 1 ZDVW\r\n" + "5 BMBT => 4 WPTQ\r\n" + "189 ORE => 9 KTJDG\r\n"
				+ "1 MZWV, 17 XDBXC, 3 XCVML => 2 XMNCP\r\n" + "12 VRPVC, 27 CNZTR => 2 XDBXC\r\n" + "15 KTJDG, 12 BHXH => 5 XCVML\r\n" + "3 BHXH, 2 VRPVC => 7 MZWV\r\n" + "121 ORE => 7 VRPVC\r\n"
				+ "7 XCVML => 6 RJRHP\r\n" + "5 BHXH, 4 VRPVC => 5 LTCX";

		this.testInput4 = "2 VPVL, 7 FWMGM, 2 CXFTF, 11 MNCFX => 1 STKFG\r\n" + "17 NVRVD, 3 JNWZP => 8 VPVL\r\n" + "53 STKFG, 6 MNCFX, 46 VJHF, 81 HVMC, 68 CXFTF, 25 GNMV => 1 FUEL\r\n"
				+ "22 VJHF, 37 MNCFX => 5 FWMGM\r\n" + "139 ORE => 4 NVRVD\r\n" + "144 ORE => 7 JNWZP\r\n" + "5 MNCFX, 7 RFSQX, 2 FWMGM, 2 VPVL, 19 CXFTF => 3 HVMC\r\n"
				+ "5 VJHF, 7 MNCFX, 9 VPVL, 37 CXFTF => 6 GNMV\r\n" + "145 ORE => 6 MNCFX\r\n" + "1 NVRVD => 8 CXFTF\r\n" + "1 VJHF, 6 MNCFX => 4 RFSQX\r\n" + "176 ORE => 6 VJHF";

		this.testInput5 = "157 ORE => 5 NZVS\r\n" + "165 ORE => 6 DCFZ\r\n" + "44 XJWVT, 5 KHKGT, 1 QDVJ, 29 NZVS, 9 GPVTF, 48 HKGWZ => 1 FUEL\r\n" + "12 HKGWZ, 1 GPVTF, 8 PSHF => 9 QDVJ\r\n"
				+ "179 ORE => 7 PSHF\r\n" + "177 ORE => 5 HKGWZ\r\n" + "7 DCFZ, 7 PSHF => 2 XJWVT\r\n" + "165 ORE => 2 GPVTF\r\n" + "3 DCFZ, 7 NZVS, 5 HKGWZ, 10 PSHF => 8 KHKGT";
	}

	@Test
	public void calculateOneUnitOfFuelOne() {
		Day14Solution unitToTest = new Day14Solution(testInput1);
		long result = unitToTest.calculateOneUnitOfFuel(new Chemical("FUEL", 1), new HashMap<>());

		assertEquals(31, result);
	}

	@Test
	public void calculateOneUnitOfFuelTwo() {
		Day14Solution unitToTest = new Day14Solution(testInput2);
		long result = unitToTest.calculateOneUnitOfFuel(new Chemical("FUEL", 1), new HashMap<>());

		assertEquals(165, result);
	}

	@Test
	public void calculateOneUnitOfFuelThree() {
		Day14Solution unitToTest = new Day14Solution(testInput3);

		long result = unitToTest.calculateOneUnitOfFuel(new Chemical("FUEL", 1), new HashMap<>());

		assertEquals(2210736, result);
	}

	@Test
	public void calculateOneUnitOfFuelFour() {
		Day14Solution unitToTest = new Day14Solution(testInput4);

		long result = unitToTest.calculateOneUnitOfFuel(new Chemical("FUEL", 1), new HashMap<>());

		assertEquals(180697, result);
	}

	@Test
	public void maximumAmountOfFuelProducedOne() {
		Day14Solution unitToTest = new Day14Solution(testInput5);

		long result = unitToTest.maximumAmountOfFuelProduced(1000000000000L);

		assertEquals(82892753, result);
	}

	@Test
	public void maximumAmountOfFuelProducedTwo() {
		Day14Solution unitToTest = new Day14Solution(testInput4);

		long result = unitToTest.maximumAmountOfFuelProduced(1000000000000L);

		assertEquals(5586022, result);
	}
}
