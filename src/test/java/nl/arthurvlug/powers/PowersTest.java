package nl.arthurvlug.powers;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class PowersTest {
	@Test(expected=IllegalArgumentException.class)
	public void testNone() throws Exception {
		new Powers();  // Should throw an exception: we need at least one item
	}

	@Test
	public void testOne() throws Exception {
		Powers powers = new Powers(1);
		List<Integer> powerList = powers.calculatePowerList(5);
		assertEquals(Arrays.asList(1), powerList);
	}

	@Test
	public void testTwo_5() throws Exception {
		Powers powers = new Powers(2);
		List<Integer> powerList = powers.calculatePowerList(5);
		assertEquals(Arrays.asList(1, 2, 4, 8, 16), powerList);
	}


	@Test
	public void testOneTwo_3() throws Exception {
		Powers powers = new Powers(1, 2);
		List<Integer> powerList = powers.calculatePowerList(3);
		assertEquals(Arrays.asList(1, 2, 4), powerList);
	}

	@Test
	public void testThree_6() throws Exception {
		Powers powers = new Powers(3);
		List<Integer> powerList = powers.calculatePowerList(6);
		assertEquals(Arrays.asList(1, 3, 9, 27, 81, 243), powerList);
	}

	@Test
	public void testTwoThree_3() throws Exception {
		Powers powers = new Powers(2, 3);
		List<Integer> powerList = powers.calculatePowerList(3);
		assertEquals(Arrays.asList(1, 2, 3), powerList);
	}

	@Test
	public void testTwoThreeFiveSeven_7() throws Exception {
		Powers powers = new Powers(2, 3, 5, 7);
		List<Integer> powerList = powers.calculatePowerList(9);
		assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9), powerList);
	}

	@Test
	public void testTwoThree_10() throws Exception {
		Powers powers = new Powers(2, 3);
		List<Integer> powerList = powers.calculatePowerList(20);
		assertEquals(Arrays.asList(1, 2, 3, 4, 6, 8, 9, 12, 16, 18, 24, 27, 32, 36, 48, 54, 64, 72, 81, 96), powerList);
	}
}
