package algoritmos.ep2;

import org.junit.Assert;
import org.junit.Test;

public class FileConnectorTest {

	FileConnector classUnderTest = new FileConnector();
	// writer
	@Test
	public void writerFileLineByLineTest() {
		String filePath = "src/test/java/algoritmos/ep2/files/writerFileTest";
		String[] expected = {"testando escrita de arquivo 1515", "linha dois"};

		classUnderTest.write(filePath, expected);
		String actual[] = classUnderTest.read(filePath);
		Assert.assertEquals(expected[0], actual[0]);
		Assert.assertEquals(expected[1], actual[1]);
	}
	
	@Test
	public void writerFileLineNumbersTest() {
		String filePath = "src/test/java/algoritmos/ep2/files/writerFileTest";
		String input[] = {"testando escrita de arquivo 1515"};
		classUnderTest.write(filePath, input);
		
		long actual = classUnderTest.discoverNumberOfLines(filePath);
		long expected = 1;
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void writerFileTest() {
		String filePath = "src/test/java/algoritmos/ep2/files/writerFileTest";
		String[] expecteds = {"linha 1", "linha 2", "linha 3"};

		classUnderTest.write(filePath, expecteds);
		String actuals[] = classUnderTest.read(filePath);
		Assert.assertArrayEquals(expecteds, actuals);
	}

	// reader
	@Test
	public void readFileTest() {
		String actual[] = classUnderTest.read("src/test/java/algoritmos/ep2/files/readerFileTest");
		String[] expected = { "{1, 2, 3, 4} u {2, 6}", "{1, 2, 3, 4} i {2, 6}", "{1, 2, 3, 4} s {2, 6}",
				"{1, 2, 3, 4}" };
		Assert.assertArrayEquals(expected, actual);
	}
	
	// number lines of file
	@Test
	public void discoverNumberOfLinesTest() {
		String filePath = "src/test/java/algoritmos/ep2/files/readerFileTest";
		long actuals = classUnderTest.discoverNumberOfLines(filePath);
		long expecteds = 4;
		Assert.assertEquals(expecteds, actuals);
		
		filePath = "src/test/java/algoritmos/ep2/files/readerFileTestOneLine";
		actuals = classUnderTest.discoverNumberOfLines(filePath);
		expecteds = 1;
		Assert.assertEquals(expecteds, actuals);
		
		filePath = "src/test/java/algoritmos/ep2/files/readerFileTestNoLines";
		actuals = classUnderTest.discoverNumberOfLines(filePath);
		expecteds = 0;
		Assert.assertEquals(expecteds, actuals);
	}
}
