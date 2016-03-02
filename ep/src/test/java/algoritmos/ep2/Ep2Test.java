package algoritmos.ep2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.junit.Test;

public class Ep2Test {
	
	Ep2 classUnderTest = new Ep2();
	
	// OPERAÇÕES
	// union
	@Test
	public void setsOperationsUnionTest(){
		String[] input = {"{1, 2, 3, 4} u {3, 4, 6}", "{1, 2, 3, 4, 10} u {4, 5, 6, 7, 10}", "{1, 2, 3, 4, 5} u {2, 5, 6, 8}"};
		String[] actuals = classUnderTest.setsOperations(input);
		String[] expecteds = {"{1,2,3,4,6}", "{1,2,3,4,5,6,7,10}", "{1,2,3,4,5,6,8}"};
		Assert.assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void setsOperationsUnionNullTest(){
		String[] input = {"{1, 2, 3, 4} u {}"};
		String[] actuals = classUnderTest.setsOperations(input);
		String[] expecteds = {"{1,2,3,4}"};
		Assert.assertArrayEquals(expecteds, actuals);
		
		String[] input2 = {"{} u {1, 2, 3, 4}"};
		actuals = classUnderTest.setsOperations(input2);
		Assert.assertArrayEquals(expecteds, actuals);
		
		String[] input3 = {"{} u {}"};
		actuals = classUnderTest.setsOperations(input3);
		String[] expecteds3 = {"{}"};
		Assert.assertArrayEquals(expecteds3, actuals);
	}

	// intersection
	@Test
	public void setsOperationsIntersectionTest(){
		String[] input = {"{1, 2, 3, 4} i {2, 4}", "{1, 2, 3, 4, 10} i {4, 6, 5, 7, 10}", "{1, 2, 3, 4, 5} i {2, 5, 6, 7, 8}"};
		String[] actuals = classUnderTest.setsOperations(input);
		String[] expecteds = {"{2,4}", "{4,10}", "{2,5}"};
		Assert.assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void setsOperationsIntersectionNullTest(){
		String[] input = {"{1, 2, 3, 4} i {}"};
		String[] actuals = classUnderTest.setsOperations(input);
		String[] expecteds = {"{}"};
		Assert.assertArrayEquals(expecteds, actuals);
		
		String[] input2 = {"{} i {1, 2, 3, 4}"};
		actuals = classUnderTest.setsOperations(input2);
		Assert.assertArrayEquals(expecteds, actuals);
		
		String[] input3 = {"{} i {}"};
		actuals = classUnderTest.setsOperations(input3);
		String[] expecteds3 = {"{}"};
		Assert.assertArrayEquals(expecteds3, actuals);
	}

	// subtraction
	@Test
	public void setsOperationsSubtractionTest(){
		String[] input = {"{4, 5, 6, 7, 8, 9, 10, 11} s {1, 2, 3, 4, 11}", "{1, 2, 3, 4, 5, 6} s {4, 6, 7, 10, 7}", "{1, 2, 3, 4, 5} s {3, 4, 6, 7}"};
		String[] actuals = classUnderTest.setsOperations(input);
		String[] expecteds = {"{5,6,7,8,9,10}", "{1,2,3,5}", "{1,2,5}"};
		Assert.assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void setsOperationsSubtractionNullTest(){
		String[] input = {"{1, 2, 3, 4} s {}"};
		String[] actuals = classUnderTest.setsOperations(input);
		String[] expecteds = {"{1,2,3,4}"};
		Assert.assertArrayEquals(expecteds, actuals);
		
		String[] input2 = {"{} s {1, 2, 3, 4}"};
		actuals = classUnderTest.setsOperations(input2);
		String[] expecteds2 = {"{}"};
		Assert.assertArrayEquals(expecteds2, actuals);
		
		String[] input3 = {"{} s {}"};
		actuals = classUnderTest.setsOperations(input3);
		String[] expecteds3 = {"{}"};
		Assert.assertArrayEquals(expecteds3, actuals);
	}

	// cardinal
	@Test
	public void setsOperationsCardinalTest(){
		String[] input = {"{1, 2, 3, 4, 5, 6, 7, 8}", "{1, 2, 3}", "{0, 1}"};
		String[] actuals = classUnderTest.setsOperations(input);
		String[] expecteds = {"8", "3", "2"};
		Assert.assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void setsOperationsCardinalNullTest(){
		String[] input = {"{}", "{}"};
		String[] actuals = classUnderTest.setsOperations(input);
		String[] expecteds = {"0", "0"};
		Assert.assertArrayEquals(expecteds, actuals);
	}
	
	//REGEX
	@Test
	public void regexStringTest(){
//		Pattern pattern = Pattern.compile(Cc52255099.REGEX_TO_EXTRACT_SETS);
		Pattern pattern = Cc52255099.pattern;
		String input = "{1, 2, 3, 4} u {2, 6}";
		Matcher matcher = pattern.matcher(input);
		Assert.assertTrue(matcher.matches());
				
		input = "{1, 2, 3, 4} s {2, 6}";
		matcher = pattern.matcher(input);
		Assert.assertTrue(matcher.matches());
		
		input = "{1, 2, 3, 4} i {2, 6}";
		matcher = pattern.matcher(input);
		Assert.assertTrue(matcher.matches());
	}
	
	@Test
	public void regexGroupTest(){
//		Pattern pattern = Pattern.compile(Cc52255099.REGEX_TO_EXTRACT_SETS);
		Pattern pattern = Cc52255099.pattern;
		String input = "{1, 2, 3, 4}u{2, 6}";
		Matcher matcher = pattern.matcher(input);
		Assert.assertTrue(matcher.matches());
		
		String actual = matcher.group(1);
		String expected = "1, 2, 3, 4";
		Assert.assertEquals(expected, actual);
		
		actual = matcher.group(2);
		expected = "u";
		Assert.assertEquals(expected, actual);
		
		actual = matcher.group(3);
		expected = "2, 6";
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void regexOpcionalTest(){
		
		String regex = ".*[uis].*";
		
		Pattern pattern = Pattern.compile(regex);
		
		String input = "{1, 2, 3, 4} u {2, 6}";
		Matcher matcher = pattern.matcher(input);
		Assert.assertTrue(matcher.matches());
				
		input = "{1, 2, 3, 4} s {2, 6}";
		matcher = pattern.matcher(input);
		Assert.assertTrue(matcher.matches());
		
		input = "{1, 2, 3, 4} i {2, 6}";
		matcher = pattern.matcher(input);
		Assert.assertTrue(matcher.matches());
	}
	
}































