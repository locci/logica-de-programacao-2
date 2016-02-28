package algoritmos.ep0;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Cc522550099 {


	public static void main(String[] args) {
		String filePath = "src/main/java/algoritmos/ep0/files/arquivo";
		Charset cs = StandardCharsets.ISO_8859_1;
		
		ReaderFile leitor = new ReaderFile();
		String retorno = leitor.read(filePath, cs);
		System.out.println(retorno);
	}

}

/**
 * Classe que com métodos para IO com arquivos
 * @author ricardo
 *
 */
class ReaderFile {
	
	/**
	 * Método que le um arquivo e mostra o conteúdo na saída padrão.
	 * @param filePath
	 * @param cs
	 */
	public String read (String filePath, Charset cs) {
		Path path = Paths.get(filePath);

		BufferedReader reader = null;
		String line = null;
		String returnData = "";

		try {
			reader = Files.newBufferedReader(path, cs);
			while ((line = reader.readLine()) != null) {
//				System.out.println(line);
				returnData = returnData + line;
			}
			
			
		} catch (IOException e) {
			System.err.println("O arquivo com o nome \"arquivo\" não foi encontrado no caminho:\n" + filePath);
		} finally {
			try {
				if (reader != null) {
					reader.close();					
				}
			} catch (IOException e) {
				System.err.println("Erro fechando o leitor de arquivo (BufferedReader)");
			}

		}
		return returnData;
	}

}
