package algoritmos.ep2;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {
	Ep2 ep2 = new Ep2();
	FileConnector file = new FileConnector();

	@Test
	public void mainTest() {
		String fileInputPath = "src/test/java/algoritmos/ep2/files/readerFileFinalTest";
		String fileOutputPath = "src/test/java/algoritmos/ep2/files/writerFileFinalTest";

		ep2.startBattle(fileInputPath, fileOutputPath);

		String[] actuals = file.read(fileOutputPath);
		String[] expecteds = { "{1,2,3,4,6}", "{2}", "{1,3,4}", "4", "{1,2,3,4,5,6,7}", "{2,4}", "{1,3,4}", "7", "{}",
				"{1,2,3,4}", "{}", "{}", "{}", "0" };
		Assert.assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void mainOfficialTest() {
		String fileInputPath = "src/test/java/algoritmos/ep2/files/entrada";
		String fileOutputPath = "src/test/java/algoritmos/ep2/files/saida";

		ep2.startBattle(fileInputPath, fileOutputPath);

		String[] actuals = file.read(fileOutputPath);
		String[] expecteds = { "14", "{17,31,35,38}", "{1,8,11,14,17,24,26,30,32,41}", "{11,19}",
				"{1,9,11,21,23,31,33,42,48}", "11", "{14,15,17,18,21,24,28,31,32,35,48}", "{5,17,27,45}",
				"{1,2,6,8,9,10,12,15,16,22,23,24,25,29,31,35,36,37,39,41,44}", "12",
				"{4,5,6,8,10,11,12,13,14,16,18,21,22,23,25,26,29,33,34,36,42,49,50}", "{4,7,26,41}", "{}", "{1}", "{}", "{}", "{}", "0" };
		Assert.assertArrayEquals(expecteds, actuals);
	}
}
