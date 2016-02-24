package algoritmos.ep1;

import org.junit.Assert;
import org.junit.Test;

public class SamplesTest {
	
	Samples classUnderTest = new Samples();

	@Test
	public void SampleReaderMatrixTest() {
		String[] actuals = classUnderTest.sampleReader("src/test/java/algoritmos/ep1/", "coorMatrix", "logMatrix", " ", 6);
		String[] expecteds = {"120202", "50"};
		Assert.assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void SampleReaderLadderTest() {
		String[] actuals = classUnderTest.sampleReader("src/test/java/algoritmos/ep1/", "coorMatrix", "logMatrix", " ", 6);
		String[] expecteds = {"120202", "50"};
		Assert.assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void SampleReaderOutOfBoundsLineTest() {
		String[] actuals = classUnderTest.sampleReader("src/test/java/algoritmos/ep1/", "coorOutBoundsLine", "logOutBoundsLine", " ", 6);
		String[] expecteds = {"120202", "50", "-1"};
		Assert.assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void SampleReaderOutOfBoundsCollumnTest() {
		String[] actuals = classUnderTest.sampleReader("src/test/java/algoritmos/ep1/", "coorOutBoundsColumn", "logOutBoundsColumn", " ", 6);
		String[] expecteds = {"120202", "50", "-1"};
		Assert.assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void SampleReaderRangeTest() {
		String[] actuals = classUnderTest.sampleReader("src/test/java/algoritmos/ep1/", "coorRange", "logRange", " ", 10);
		String[] expecteds = {"120202", "50", "-1", "-1", "88", "138", "23770", "01", "-1"};
		Assert.assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void SampleReaderNoErrorTest() {
		classUnderTest.sampleReader("src/test/java/algoritmos/ep1/", "coor", "logHorm1", " ", 100);
		Assert.assertTrue(true);
		
	}

}
