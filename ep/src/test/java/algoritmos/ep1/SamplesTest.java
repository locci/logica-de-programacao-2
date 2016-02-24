package algoritmos.ep1;

import org.junit.Assert;
import org.junit.Test;

public class SamplesTest {
	
	Samples classUnderTest = new Samples();

	@Test
	public void SampleReaderMatrixTest() {
		String[] actuals = classUnderTest.sampleReader("src/test/java/algoritmos/ep1/", "logMatrix", "coorMatrix", " ", 4,
				6);
		String[] expecteds = {"120202", "50"};
		Assert.assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void SampleReaderLadderTest() {
		String[] actuals = classUnderTest.sampleReader("src/test/java/algoritmos/ep1/", "logLadder", "coorLadder", " ", 4,
				6);
		String[] expecteds = {"120202", "-1", "50"};
		Assert.assertArrayEquals(expecteds, actuals);
	}

}
