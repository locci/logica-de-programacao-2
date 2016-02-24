package algoritmos.ep1;

import org.junit.Assert;
import org.junit.Test;

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
	public void fileToArraySReadNullTest() {
		String[][] actuals = underTest.fileToArray("src/test/java/algoritmos/ep1/logLadder", " ", 4, 7);
		String[][] expecteds = {{"120202", "138", "23770", "88", "95430", "38", null},
								{"120202", "138", "23770", "88", "95430", "01", null},
								{"120202", "138", "23770", "88", null, null, null},
								{"120202", "138", "23770", "88", "95430", "50", null}
								
		};
		Assert.assertArrayEquals(expecteds, actuals);
	}
	
	
	@Test
	public void loadArrayTest(){
		String[][] actuals = underTest.loadArray(5, 4, "-1");
		String[][] expecteds = {{"-1", "-1", "-1", "-1"},
								{"-1", "-1", "-1", "-1"},
								{"-1", "-1", "-1", "-1"},
								{"-1", "-1", "-1", "-1"},
								{"-1", "-1", "-1", "-1"}
		};
		Assert.assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void fileToVectorSingleLineFileTest() {
		String filePath = "src/test/java/algoritmos/ep1/logSingleLine";
		String regex = " ";
		int[] actuals = underTest.fileToVector(filePath, regex);
		int[] expecteds = {120202, 138, 23770, 88, 95430, 38};
		Assert.assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void fileToVectorSingleLineLoadTest() {
		String filePath = "src/test/java/algoritmos/ep1/logSingleLine";
		String regex = " ";
		int[] actuals = underTest.fileToVector(filePath, regex);
		int actual = actuals.length;
		int expected = 6;
		Assert.assertEquals(expected, actual);
		
		filePath = "src/test/java/algoritmos/ep1/coor";
		actuals = underTest.fileToVector(filePath, regex);
		actual = actuals.length;
		expected = 166672;
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void fileToVectorMultipleFileTest() {
		String filePath = "src/test/java/algoritmos/ep1/logLadder";
		String regex = " ";
		int[] actuals = underTest.fileToVector(filePath, regex);
		int[] expecteds = {120202, 138, 23770, 88, 95430, 38};
		Assert.assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void discoverNumberOfLinesTest() {
		String filePath = "src/test/java/algoritmos/ep1/logHorm2";
		long actuals = underTest.discoverNumberOfLines(filePath);
		long expecteds = 38431;
		Assert.assertEquals(expecteds, actuals);
		
		filePath = "src/test/java/algoritmos/ep1/logLadder";
		actuals = underTest.discoverNumberOfLines(filePath);
		expecteds = 4;
		Assert.assertEquals(expecteds, actuals);
		
		filePath = "src/test/java/algoritmos/ep1/coorLadder";
		actuals = underTest.discoverNumberOfLines(filePath);
		expecteds = 1;
		Assert.assertEquals(expecteds, actuals);

		/*Deve haver alguma incompatibilidade da classe File com arquivos grandes*/
		
//		filePath = "src/test/java/algoritmos/ep1/coor";
//		actuals = underTest.discoverNumberOfLines(filePath);
//		expecteds = 1;
//		Assert.assertEquals(expecteds, actuals);
	}
	
	@Test
	public void coorFileTest() {
		
		String filePath = "src/test/java/algoritmos/ep1/coor";
		int[] actualsVector = underTest.fileToVector(filePath, " ");
		int actual = actualsVector.length;
		int expected = 166672;
		Assert.assertEquals(expected, actual);
		
//		String[][] actualsArray = underTest.fileToArray(filePath, " ", 2, actual);
//		String actual2 = actualsArray[1][0];
//		String expected2 = "-1";
//		Assert.assertEquals(expected2, actual2);
		
		int actual2 = actualsVector[actual-1];
		int expected2 = 137;
		Assert.assertEquals(expected2, actual2);

		
	}
	
}




