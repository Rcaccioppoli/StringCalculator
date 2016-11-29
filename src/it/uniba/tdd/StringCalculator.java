package it.uniba.tdd;

public class StringCalculator {
	public int add(String numbersStr) {
		int result=0;
		String[] numbers;
		
		if (numbersStr.length()==0)
			result=0;
		else{
			numbers = parser(numbersStr);
			try {
				result = total(numbers);
			} catch (StringCalculatorException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

	private String[] parser(String numbersStr) {
		String parsedString="";
		String delimiter = createDelimiter(numbersStr);
		
		for (int i=0; i<numbersStr.length(); i++) {
			if (Character.isDigit(numbersStr.charAt(i)) || numbersStr.charAt(i)=='-')
				parsedString+=numbersStr.charAt(i);
			else
				parsedString+=delimiter;
		}
		
		return removeEmpty(parsedString.split(delimiter));
	}

	private String[] removeEmpty(String[] split) {
		int j=0;
		
		for (int i=0; i<split.length; i++)
			if (!split[i].isEmpty())
			{
				split[j]=split[i];
				j++;
			}
		
		String[] result = new String[j];
		
		System.arraycopy(split, 0, result, 0, j);
		
		return result;
	}

	private String createDelimiter(String numbersStr) {
		String delimiter = "";
		
		if(numbersStr.split("\n").length > 1)
			if (numbersStr.split("\n")[0].split("//").length > 1)
				delimiter=numbersStr.split("\n")[0].split("//")[1];
		
		if(delimiter.isEmpty())
			delimiter=",";
		
		return delimiter;
	}

	private int total(String[] numbers) throws StringCalculatorException {
		int result = 0;
		
		for (int i=0; i<numbers.length; i++) {
			if (Integer.parseInt(numbers[i]) >= 0) {
				result += Integer.parseInt(numbers[i]);
			}
			else
				throw new StringCalculatorException();	
		}
		
		return result;
	}
}