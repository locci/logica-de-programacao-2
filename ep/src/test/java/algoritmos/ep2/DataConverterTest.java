package algoritmos.ep2;

import org.junit.Assert;
import org.junit.Test;

public class DataConverterTest {
	
	DataConverter classUnderTest = new DataConverter();
	
	@Test
	public void stringToIntArrayTest(){
		final String split_regex = Cc52255099.SPLIT_REGEX;
		String group = "1, 2, 3, 4";
		
		int[] actuals = classUnderTest.stringToIntArray(group, split_regex);
		int[] expecteds = {1, 2, 3, 4};
		Assert.assertArrayEquals(expecteds, actuals);
	}

}
