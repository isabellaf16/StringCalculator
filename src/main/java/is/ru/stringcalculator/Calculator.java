package is.ru.stringcalculator;
import java.util.*;

public class Calculator {
	public static int add(String text) {
		if(text.equals("")) {
			return 0;
		}
		else {
			if(text.contains(",")) {
				//String numbers[] = text.split(",");
				//String numbers[] = text.split(",|/n");
				String numbers[] = multipleDelimiters(text);
				negativeNumbers(numbers);
				return sum(numbers);
				//return toInt(numbers[0]) + toInt(numbers[1]);
			}

			return 1;
		}
	}

	private static int toInt(String number) {
		return Integer.parseInt(number);
	}

	private static int sum(String [] numbers) {
		int total = 0;
		for(String number : numbers) {
			if(toInt(number) <= 1000) {
				total += toInt(number);
			}
			
		}
		return total;
	}

	private static void negativeNumbers(String[] numbers) {
		List<String> negativeNumb = new ArrayList<String>();
		for(int i = 0; i < numbers.length; i++) {
			if(numbers[i].matches("-.*")) {
				negativeNumb.add(numbers[i]);
			}
		}


		if(!negativeNumb.isEmpty()) {
			String negativeList = negativeNumb.get(0);
			for(int i = 1; i < negativeNumb.size(); i++) {
				negativeList += "," + negativeNumb.get(i);
			}
			throw new IllegalArgumentException("Negatives not allowed: " + negativeList);
		}
	}

	private static String[] multipleDelimiters(String text) {
		String[] numbers = null;
		String delimitor = "";
		if(text.startsWith("//")) {
			text = text.substring(2);
			String[] temp = text.split("\n", 2);
			delimitor = temp[0];
			numbers = temp[1].split(delimitor + "|,|\n");
		} 
		else {
			numbers = text.split(",|\n");
		}
		return numbers;
	}

	 public static void main(String[] args) {

	 }
}