package algoritmos.ep0;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import org.junit.Assert;
import org.junit.Test;

public class readerFileTest {

	ReaderFile classUnderTest = new ReaderFile();

	@Test
	public void readeFileTest() {
		String filePath = "src/main/java/algoritmos/ep0/files/arquivo";
		Charset cs = StandardCharsets.ISO_8859_1;
		String actual = classUnderTest.read(filePath, cs);
		String expected = "1 jj2 kk3 hh45 oo pp";
		Assert.assertEquals(expected, actual);
	}

}
