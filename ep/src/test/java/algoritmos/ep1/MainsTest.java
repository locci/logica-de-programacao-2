package algoritmos.ep1;

import org.junit.Assert;
import org.junit.Test;

public class MainsTest {

	Samples classUnderTest = new Samples();
	
	@Test
	public void MainLogHorm1Test() {
		classUnderTest.sampleReader("src/test/java/algoritmos/ep1/", "coor", "logHorm1", " ", 100);
		Assert.assertTrue(true);
		
	}
	
	@Test
	public void MainLogHorm2Test() {
		classUnderTest.sampleReader("src/test/java/algoritmos/ep1/", "coor", "logHorm2", " ", 100);
		Assert.assertTrue(true);
		
	}
	
	@Test
	public void MainLogHorm3Test() {
		classUnderTest.sampleReader("src/test/java/algoritmos/ep1/", "coor", "logHorm3", " ", 100);
		Assert.assertTrue(true);
		
	}

}
