package algoritmos.ep1;

import org.junit.Assert;
import org.junit.Test;

public class MainsTest {

	Samples classUnderTest = new Samples();
	
	@Test
	public void MainTest() {
		String[] actuals = classUnderTest.sampleReader("src/main/java/algoritmos/ep1/", "logHorm1", "coor", " ", 3000,
				100);
//		String[] actuals = classUnderTest.sampleReader("src/main/test/algoritmos/ep1/", "logLadder", "coorLadder", " ", 4,
		String[] expecteds = {"120202", "-1", "50"};
		Assert.assertArrayEquals(expecteds, actuals);
		Assert.assertTrue(true);
	}

}
