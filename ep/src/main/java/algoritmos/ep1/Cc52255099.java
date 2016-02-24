package algoritmos.ep1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
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
		Samples sample = new Samples();
		sample.sampleReader("src/test/java/algoritmos/ep1/", "coor", "logHorm1", " ", 100);
	}

}

/**
 * 
 * @author ricardo
 *
 */
class Samples {

	public String[] sampleReader(String folderPath, String coorName, String logName, String regex, int quantidadeDeColunasLog) {
		ReaderFile reader = new ReaderFile();
		
		String coorFilePath = folderPath + coorName;
		String logFilePath = folderPath + logName;
		int quantidadeDeLinhadDoArquivoDeLog = (int)reader.discoverNumberOfLines(logFilePath);
		
		int[] coorArray = reader.fileToVector(coorFilePath, regex);
		String[][] logHormArray = reader.fileToArray(logFilePath, regex, quantidadeDeLinhadDoArquivoDeLog, quantidadeDeColunasLog);
				
		String[] returnArray = new String[coorArray.length / 2];
		
		int indiceReturnArray = 0;
		for (int i = 0; i < coorArray.length;) {
			int line = coorArray[i];
			int column = coorArray[i+1];
			if (line >= quantidadeDeLinhadDoArquivoDeLog || column >= quantidadeDeColunasLog || logHormArray[line][column] == null) {
				returnArray[indiceReturnArray] = "-1";
				//TODO sysout oficial do resultado
				System.out.println("-1");
			}else{
				//TODO sysout oficial do resultado
				System.out.println(logHormArray[line][column]);
				returnArray[indiceReturnArray] = logHormArray[line][column];				
			}
			i = i+2;
			indiceReturnArray++;
		}

		
		
		return returnArray;
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

		String[][] arrayToReturned = new String[quantidadeDeLinhadDoArquivo][quantidadeDeColunasDoArquivo];
//		String[][] arrayToReturned = loadArray(quantidadeDeLinhadDoArquivoTest, quantidadeDeColunasDoArquivo, "-1");

		try {
			bfr = Files.newBufferedReader(path, cs);
			String line = null;
			int i = 0;
			while ((line = bfr.readLine()) != null) {
					String[] vector = line.split(regex);
					for (int j = 0; j < vector.length; j++) {
						arrayToReturned[i][j] = vector[j];
					}
					i++;
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
	 * Descobrir a quantidade de linhas de um arquivo
	 * 
	 * @param uri
	 * @return
	 */
	public long discoverNumberOfLines(String uri) {

		int numberOfLines = 0;
		try {
			File file = new File(uri);
			@SuppressWarnings("resource")
			LineNumberReader line = new LineNumberReader(new FileReader(file));
			line.skip(file.length());
			numberOfLines = line.getLineNumber();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return numberOfLines;
	}

	/**
	 * prepara um array preenchido com uma string padrão recebida no parâmetro
	 * "patern", esse array está pronto para receber os dados do logHorm
	 * 
	 * @param lineSize
	 * @param columnSize
	 * @param pattern
	 * @return string[][] - preenchido com uma string padrão
	 */
	public String[][] loadArray(int lineSize, int columnSize, String pattern) {
		String[][] array = new String[lineSize][columnSize];
		for (int i = 0; i < lineSize; i++) {
			for (int j = 0; j < columnSize; j++) {
				array[i][j] = pattern;
			}
		}
		return array;
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
	public int[] fileToVector(String filePath, String regex) {
		Charset cs = StandardCharsets.UTF_8;
		Path path = Paths.get(filePath);
		BufferedReader bfr = null;

		String[] vector = null;

		try {

			bfr = Files.newBufferedReader(path, cs);
			vector = bfr.readLine().split(regex);

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
		int[] vectorToReturn = convertStringArrayToIntArray(vector);
		return vectorToReturn;
	}

	/**
	 * converte um array de strings em um array de inteiros 
	 * @param vector
	 * @return int[]
	 */
	private int[] convertStringArrayToIntArray(String[] vector) {
		int[] vectorToReturn = new int[vector.length];
		for (int i = 0; i < vector.length; i++) {
			vectorToReturn[i] = Integer.parseInt(vector[i]);
		}
		return vectorToReturn;
	}

}
