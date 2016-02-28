package algoritmos.ep2;

import org.junit.Assert;
import org.junit.Test;

public class NumericalSetsTest {

	NumericalSets classUnderTest = new NumericalSets();

	// union
	@Test
	public void unionTest() {
		int[] set1 = { 1, 2, 3, 4 };
		int[] set2 = { 2, 6 };
		String actual = classUnderTest.union(set1, set2);
		String expected = "{1, 2, 3, 4, 6}";
		Assert.assertEquals(expected, actual);
	}

	// intersection
	@Test
	public void intersectionTest() {
		int[] set1 = { 1, 2, 3, 4 };
		int[] set2 = { 2, 6 };
		String actual = classUnderTest.intersection(set1, set2);
		String expected = "{2}";
		Assert.assertEquals(expected, actual);
	}

	// subtraction
	@Test
	public void subtractionTest() {
		int[] set1 = { 1, 2, 3, 4 };
		int[] set2 = { 2, 6 };
		String actual = classUnderTest.subtraction(set1, set2);
		String expected = "{1, 3, 4}";
		Assert.assertEquals(expected, actual);
	}

	// cardinal
	@Test
	public void cardinalTest() {
		String actual = classUnderTest.cardinal("{1, 2, 3, 4, 6}");
		String expected = "5";
		Assert.assertEquals(expected, actual);
	}

	// Sort
	@Test
	public void sortTest() {
		int[] set1 = { 1, 2, 3, 4 };
		int[] set2 = { 3, 6 };
		int[] actuals = classUnderTest.sort(set1, set2);
		int[] expecteds = { 0, 1, 1, 2, 1, 0, 1 };
		Assert.assertArrayEquals(expecteds, actuals);
	}

	// Sort left join
	@Test
	public void sortLeftJoinTest() {
		int[] set1 = { 1, 2, 3, 4 };
		int[] set2 = { 3, 6 };
		int[] actuals = classUnderTest.sortLeftJoin(set1, set2);
		int[] expecteds = { 0, 1, 1, 2, 1, 0, 0 };
		Assert.assertArrayEquals(expecteds, actuals);
	}

	// greaterNumber
	@Test
	public void greaterNumberFirstVectorTest() {
		int[] set1 = { 8, 0, 9, 7 };
		int[] set2 = { 2, 6, 5, 0 };
		int actual = classUnderTest.greaterNumber(set1, set2);
		int expected = 9;
		Assert.assertEquals(expected, actual);

		set1[2] = 15;
		actual = classUnderTest.greaterNumber(set1, set2);
		expected = 15;
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void greaterNumberSecondVectorTest() {
		int[] set1 = { 8, 0, 5, 7 };
		int[] set2 = { 2, 6, 9, 0 };
		int actual = classUnderTest.greaterNumber(set1, set2);
		int expected = 9;
		Assert.assertEquals(expected, actual);

		set2[2] = 15;
		actual = classUnderTest.greaterNumber(set1, set2);
		expected = 15;
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void greaterNumberZeroTest() {
		int[] set1 = { 0, 0, 0, 0 };
		int[] set2 = { 0, 0, 0, 0 };
		int actual = classUnderTest.greaterNumber(set1, set2);
		int expected = 0;
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void greaterNumberRepeatTest() {
		int[] set1 = { 2, 3, 4, 5 };
		int[] set2 = { 5, 4, 3, 2 };
		int actual = classUnderTest.greaterNumber(set1, set2);
		int expected = 5;
		Assert.assertEquals(expected, actual);

		set2[2] = 0;
		actual = classUnderTest.greaterNumber(set1, set2);
		expected = 5;
		Assert.assertEquals(expected, actual);

	}

	// loadArray
	@Test
	public void loadArrayTest() {
		int[] actuals = classUnderTest.loadArray(10);
		int[] expecteds = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		Assert.assertArrayEquals(expecteds, actuals);
	}

}
