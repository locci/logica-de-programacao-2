package algoritmos.ep2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Exercicio proposto na aula de Lógica de programação
 * 
 * @author ricardo
 * @professor Alexandre
 */
public class Cc52255099 {
	public static final String SPLIT_REGEX = ", ";
	public static final String REGEX_TO_EXTRACT_SETS = "\\{([\\d,\\s]*)\\}\\s([uis])\\s\\{([\\d,\\s]*)\\}";
	public static final Charset CS = StandardCharsets.UTF_8;
	public static Pattern pattern = Pattern.compile(REGEX_TO_EXTRACT_SETS);

	public static void main(String[] args) {

		String outputFile = "src/main/java/algoritmos/ep2/files/answers";
		String inputFile = "src/main/java/algoritmos/ep2/files/questions";

		new Ep2().startBattle(inputFile, outputFile);
		System.out.println("/n/n/n/nCálculos concluídos./n/n/n");

	}
}

/**
 * Classe principal do EP2 que lê as linhas de um arquivo de executa a operação
 * matemática relacionada com a teoria de conjuntos descrita
 * 
 * @author ricardo
 *
 */
class Ep2 {
	FileConnector file = new FileConnector();
	DataConverter converter = new DataConverter();
	NumericalSets sets = new NumericalSets();

	/**
	 * Inicia os métodos de leitura do arquivo buscando conjuntos e operações em
	 * cada linha do mesmo, executa a operação indicada e salva em um arquivo o
	 * resultado, assim como o arquivo de entrada o resultado é mostrado um em
	 * cada linha do arquivo de saída.
	 * 
	 * @param inputFile
	 * @param outputFile
	 */
	public void startBattle(String inputFile, String outputFile) {
		String[] questionLines = file.read(inputFile);
		String[] answerLines = setsOperations(questionLines);
		file.write(outputFile, answerLines);
	}

	/**
	 * Recebe um array de strings com as linhas do arquivo de entrada, varre a
	 * string para encontrar a operação indicada e os conjuntos que se
	 * submeterão a ela. O retorno é um array de strings com o resultado das
	 * operações
	 * 
	 * @param questionLines
	 * @return String[]
	 */
	public String[] setsOperations(String[] questionLines) {
		final Pattern pattern = Cc52255099.pattern;
		final String split_regex = Cc52255099.SPLIT_REGEX;
		String[] answerLines = new String[questionLines.length];

		for (int i = 0; i < questionLines.length; i++) {
			Matcher matcher = pattern.matcher(questionLines[i]);
			if (matcher.matches()) {
				int[] set1 = {};
				int[] set2 = {};
				if(!(matcher.group(1).equals(""))){
					set1 = converter.stringToIntArray(matcher.group(1), split_regex);
				}
				if(!(matcher.group(3).equals(""))){
					set2 = converter.stringToIntArray(matcher.group(3), split_regex);
				}
				switch (matcher.group(2)) {
				case "u":

					answerLines[i] = sets.union(set1, set2);
					break;
				case "i":
					answerLines[i] = sets.intersection(set1, set2);
					break;
				case "s":
					answerLines[i] = sets.subtraction(set1, set2);
					break;
				default:
					// TODO sysout
					System.out.println("Entrou no default do switch");
					answerLines[i] = "ERROR!";
					break;
				}
			} else {
				if (questionLines[i].equals("{}")) {
					answerLines[i] = "0";
				} else{
					answerLines[i] = sets.cardinal(questionLines[i]);
				}
			}
		}
		return answerLines;
	}

}

/**
 * Operações de leitura e escrita em arquivo
 * 
 * @author ricardo
 *
 */
class FileConnector {

	/**
	 * Método que le um arquivo e retorna as linhas em um array de strings.
	 * 
	 * @param filePath
	 * @param cs
	 * @return String[]
	 */
	public String[] read(String filePath) {
		Path path = Paths.get(filePath);

		BufferedReader reader = null;
		String line = null;
		int numberFileLines = (int) discoverNumberOfLines(filePath);
		String[] returnData = new String[numberFileLines];

		try {
			reader = Files.newBufferedReader(path, Cc52255099.CS);
			int i = 0;
			while ((line = reader.readLine()) != null) {
				returnData[i] = line;
				i++;
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

	/**
	 * Conta a quantidade de linhas de um arquivo
	 * 
	 * @param uri
	 * @return long
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
	 * Escreve uma string em um arquivo sobreescrevendo o conteúdo original ou
	 * criando um arquivo novo caso ele não exista
	 * 
	 * @param filePath
	 * @param cs
	 * @param content
	 */
	public void write(String filePath, String[] content) {

		Path path = Paths.get(filePath);
		BufferedWriter writer = null;
		try {
			writer = Files.newBufferedWriter(path, Cc52255099.CS);
			for (int i = 0; i < content.length; i++) {
				writer.write(content[i]);
				writer.newLine();
			}
			writer.flush();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			try {
				if (writer != null) {
					writer.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}

/**
 * Classe para fazer o tratamento e conversão de dados
 * 
 * @author ricardo
 *
 */
class DataConverter {

	/**
	 * Converte uma string em um array de strings baseado em um regex para
	 * cortar a string e converte cada string em um inteiro retornando por fim
	 * um array unidimensional de inteiros
	 * 
	 * @param group
	 * @param split_regex
	 * @return int[]
	 */
	public int[] stringToIntArray(String group, String split_regex) {
		String[] groups = group.split(split_regex);
		int[] returnVector = new int[groups.length];
		for (int i = 0; i < groups.length; i++) {
			returnVector[i] = Integer.parseInt(groups[i]);
		}
		return returnVector;
	}
}

/**
 * Classe com operações de conjuntos matemáticos
 * 
 * @author ricardo
 *
 */
class NumericalSets {

	/**
	 * Realiza a operação de união entre dois conjuntos e devolve uma string do
	 * conjunto resultado
	 * 
	 * @param set1
	 * @param set2
	 * @return String
	 */
	public String union(int[] set1, int[] set2) {
		int[] setElements = sort(set1, set2);
		String returnData = "";
		for (int i = 0; i < setElements.length; i++) {
			if (setElements[i] != 0) {
				returnData = returnData + i + ", ";
			}
		}
		returnData = addCurlyBrackets(returnData);
		return returnData;
	}

	/**
	 * Realiza a operação de intersecção entre dois conjuntos e devolve uma
	 * string do conjunto resultado
	 * 
	 * @param set1
	 * @param set2
	 * @return String
	 */
	public String intersection(int[] set1, int[] set2) {
		int[] setElements = sort(set1, set2);
		String returnData = "";
		for (int i = 0; i < setElements.length; i++) {
			if (setElements[i] > 1) {
				returnData = returnData + i + ", ";
			}
		}
		returnData = addCurlyBrackets(returnData);
		return returnData;
	}

	/**
	 * Realiza a operação de subtração entre dois conjuntos e devolve uma string
	 * do conjunto resultado
	 * 
	 * @param set1
	 * @param set2
	 * @return String
	 */
	public String subtraction(int[] set1, int[] set2) {
		int[] setElements = sortLeftJoin(set1, set2);
		String returnData = "";
		for (int i = 0; i < setElements.length; i++) {
			if (setElements[i] == 1) {
				returnData = returnData + i + ", ";
			}
		}
		returnData = addCurlyBrackets(returnData);
		return returnData;
	}

	/**
	 * Remver os ultimos espaços e virgulas acrescentar as chaves e retornar a
	 * string
	 * 
	 * @param text
	 * @return String - conjunto numérico no formato matemático
	 */
	public String addCurlyBrackets(String text) {
		int textSize = text.length();
		if (textSize > 1) {
			text = text.substring(0, textSize - 2);
		}
		text = "{" + text + "}";
		return text;
	}

	/**
	 * Conta o número de elementos do conjuntoe retorna um número no formato
	 * string
	 * 
	 * @param string
	 * @return string
	 */
	public String cardinal(String string) {
		String tokens[] = string.split(Cc52255099.SPLIT_REGEX);
		String returnData = String.valueOf(tokens.length);
		return returnData;
	}

	/**
	 * Sort - Varre dois arrays e retorna um array com o número de elementos de
	 * cada item.
	 * 
	 * @param set1
	 *            array de inteiros
	 * @param set2
	 *            array de inteiros
	 * @return int[]
	 */
	public int[] sort(int[] set1, int[] set2) {
		int arraySize = greaterNumber(set1, set2);
		int[] returnArray = loadArray(arraySize + 1);

		for (int i = 0; i < set1.length; i++) {
			returnArray[set1[i]]++;
		}
		for (int i = 0; i < set2.length; i++) {
			returnArray[set2[i]]++;
		}
		return returnArray;
	}

	/**
	 * Sort - Varre dois arrays e verificando se os elementos do conjunto dois
	 * encontram-se no conjunto um. Os elementos do conjunto dois que não sejam
	 * intersecção com o conjunto um são ignorados.
	 * 
	 * @param set1
	 *            array de inteiros
	 * @param set2
	 *            array de inteiros
	 * @return int[]
	 */
	public int[] sortLeftJoin(int[] set1, int[] set2) {
		int arraySize = greaterNumber(set1, set2);
		int[] returnArray = loadArray(arraySize + 1);

		for (int i = 0; i < set1.length; i++) {
			returnArray[set1[i]]++;
		}
		for (int i = 0; i < set2.length; i++) {
			if (returnArray[set2[i]] != 0) {
				returnArray[set2[i]]++;
			}
		}
		return returnArray;
	}

	/**
	 * Encontra o maior numero de dois arrays
	 * 
	 * @param set1
	 * @param set2
	 * @return
	 */
	public int greaterNumber(int[] set1, int[] set2) {
		int greaterNumber = 0;

		for (int i = 0; i < set1.length; i++) {
			if (set1[i] > greaterNumber) {
				greaterNumber = set1[i];
			}
		}
		for (int i = 0; i < set2.length; i++) {
			if (set2[i] > greaterNumber) {
				greaterNumber = set2[i];
			}
		}
		return greaterNumber;
	}

	/**
	 * devolve um array de inteiros preenchido com zeros
	 * 
	 * @param arraySize
	 * @return int[] - todas as posições iguais a zero
	 */
	public int[] loadArray(int arraySize) {
		int[] returnArray = new int[arraySize];
		for (int i = 0; i < returnArray.length; i++) {
			returnArray[i] = 0;
		}
		return returnArray;
	}

}
