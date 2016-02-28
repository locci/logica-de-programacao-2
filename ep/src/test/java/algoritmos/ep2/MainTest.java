package algoritmos.ep2;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {
	Ep2 ep2 = new Ep2();
	FileConnector file = new FileConnector();

	@Test
	public void mainTest() {
		String fileOutputPath = "src/test/java/algoritmos/ep2/files/writerFileFinalTest";
		String fileInputPath = "src/test/java/algoritmos/ep2/files/readerFileFinalTest";
		
		ep2.startBattle(fileInputPath, fileOutputPath);
		
		
		String[] actuals = file.read(fileOutputPath);
		String[] expecteds = { "{1, 2, 3, 4, 6}", "{2}", "{1, 3, 4}", "4", "{1, 2, 3, 4, 5, 6, 7}", "{2, 4}",
				"{1, 3, 4}", "7", "{}", "{1, 2, 3, 4}" };
		Assert.assertArrayEquals(expecteds, actuals);
	}
}
