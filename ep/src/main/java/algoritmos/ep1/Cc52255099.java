package algoritmos.ep1;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Hello world!
 *
 */
public class Cc52255099 {
	public static void main(String[] args) {
		System.out.println("Hello World!");
	}

}

/**
 * 
 * @author ricardo
 *
 */
class Samples {

	public String[] sampleReader(String folderPath, String logFileName, String coorFileName, String regex, int lineNumbersOnLogFile,
			int columnNumbersOnLogFile) {
		
		ReaderFile reader = new ReaderFile();
		
		
		String logFilePath = folderPath + logFileName;
		String coorFilePath = (folderPath + coorFileName);
				
		String[] coorArray = reader.fileToVector(coorFilePath, regex);
		String[][] logArray = reader.fileToArray(logFilePath, regex, lineNumbersOnLogFile, columnNumbersOnLogFile);
		String[] arrayDataToReturn = new String[coorArray.length / 2];
		
		int coorCount = 0;
		int lineToRead = 0;
		int columnToRead = 0;
		for (int i = 0; i < arrayDataToReturn.length; i++) {
			lineToRead = Integer.parseInt(coorArray[coorCount++]);
			columnToRead = Integer.parseInt(coorArray[coorCount++]);
			if (logArray[lineToRead][columnToRead] == null) {
				arrayDataToReturn[i] = "-1";
			} else{
				arrayDataToReturn[i] = logArray[lineToRead][columnToRead];
			}
			System.out.println(logArray[lineToRead][columnToRead]);
		}
		return arrayDataToReturn;
	}

}

/**
 * Classe que le dados de arquivos
 * 
 * @author ricardo
 *
 */
class ReaderFile {

	/**
	 * Lê um arquivo e armazena os dados em um array que é retornado. O retorno
	 * é um array multidimensional e os dados do arquivo serão separados por uma
	 * expressão regex recebida no parâmetro O charset usado é o UTF_8.
	 * 
	 * @param filePath
	 * @param quantidadeDeLinhadDoArquivo
	 * @param quantidadeDeColunasDoArquivo
	 * @param regex
	 * @return Array de Strings com duas dimensões
	 */
	public String[][] fileToArray(String filePath, String regex, int quantidadeDeLinhadDoArquivo,
			int quantidadeDeColunasDoArquivo) {
		Charset cs = StandardCharsets.UTF_8;
		Path path = Paths.get(filePath);
		BufferedReader bfr = null;

		String[] line;
		String[][] arrayToReturned = new String[quantidadeDeLinhadDoArquivo][quantidadeDeColunasDoArquivo];

		try {

			bfr = Files.newBufferedReader(path, cs);
			for (int i = 0; i < quantidadeDeLinhadDoArquivo; i++) {
				line = bfr.readLine().split(regex);
				for (int j = 0; j < line.length; j++) {
					arrayToReturned[i][j] = line[j];
				}
			}
		} catch (IOException e) {
			System.err.println("Erro de acesso ao arquivo verifique se ele existe e se você tem permissão de leitura");
		} finally {
			try {
				if (bfr != null) {
					bfr.close();
				}
			} catch (Exception e2) {
				System.err.println("Erro ao fechar o arquivo");
			}
		}
		return arrayToReturned;
	}

	/**
	 * Lê uma linha de um arquivo e armazena os dados em um vetor que é
	 * retornado. O retorno é um array unidimensional e os dados do arquivo
	 * serão separados por uma expressão regex recebida no parâmetro. O charset
	 * usado é o UTF_8.
	 * 
	 * @param filePath
	 * @param regex
	 * @return array unidimensional de Strings
	 */
	public String[] fileToVector(String filePath, String regex) {
		Charset cs = StandardCharsets.UTF_8;
		Path path = Paths.get(filePath);
		BufferedReader bfr = null;

		String[] vectorToReturn = null;

		try {

			bfr = Files.newBufferedReader(path, cs);
			vectorToReturn = bfr.readLine().split(regex);

		} catch (IOException e) {
			System.err.println("Erro de acesso ao arquivo verifique se ele existe e se você tem permissão de leitura");
		} finally {
			try {
				if (bfr != null) {
					bfr.close();
				}
			} catch (Exception e2) {
				System.err.println("Erro ao fechar o arquivo");
			}
		}

		return vectorToReturn;
	}

}
