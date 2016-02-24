package algoritmos.ep1;

import org.junit.Assert;
import org.junit.Test;

import algoritmos.ep1.Cc52255099;

public class ReaderFileTest {
	
	Cc52255099 teste;
	ReaderFile underTest = new ReaderFile();
	
	@Test
	public void fileToArrayMatrixTest() {
		String[][] actuals = underTest.fileToArray("src/test/java/algoritmos/ep1/logMatrix", " ", 4, 6);
		String[][] expecteds = {{"120202", "138", "23770", "88", "95430", "38"},
								{"120202", "138", "23770", "88", "95430", "01"},
								{"120202", "138", "23770", "88", "95430", "77"},
								{"120202", "138", "23770", "88", "95430", "50"}
		};		
		Assert.assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void fileToArrayLadderTest() {
		String[][] actuals = underTest.fileToArray("src/test/java/algoritmos/ep1/logLadder", " ", 4, 6);
		String[][] expecteds = {{"120202", "138", "23770", "88", "95430", "38"},
								{"120202", "138", "23770", "88", "95430", "01"},
								{"120202", "138", "23770", "88", null, null},
								{"120202", "138", "23770", "88", "95430", "50"}
		};
		Assert.assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void fileToArraySingleLineTest() {
		String[][] actuals = underTest.fileToArray("src/test/java/algoritmos/ep1/logSingleLine", " ", 1, 6);
		String[][] expecteds = {{"120202", "138", "23770", "88", "95430", "38"}};
		Assert.assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void fileToVectorSingleLineFileTest() {
		String filePath = "src/test/java/algoritmos/ep1/logSingleLine";
		String regex = " ";
		String[] actuals = underTest.fileToVector(filePath, regex);
		String[] expecteds = {"120202", "138", "23770", "88", "95430", "38"};
		Assert.assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void fileToVectorMultipleFileTest() {
		String filePath = "src/test/java/algoritmos/ep1/logLadder";
		String regex = " ";
		String[] actuals = underTest.fileToVector(filePath, regex);
		String[] expecteds = {"120202", "138", "23770", "88", "95430", "38"};
		Assert.assertArrayEquals(expecteds, actuals);
	}
	
}




