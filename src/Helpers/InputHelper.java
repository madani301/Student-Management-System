/**
* 
*InputHelper allows user to input data & handles potential errors from the user.
*/
package Helpers;

import java.util.Scanner;

/**
*
* @author madani 
*/
public class InputHelper {
	private final Scanner reader;

/**
*Creates a new Scanner to read user input.
*/
	public InputHelper() {
		reader = new Scanner(System. in );
	}

/**
*Read characters.
* @param prompt
* @return
*/
	public char readCharacter(String prompt) {

		System.out.println(prompt + ": ");
		char inputText = reader.nextLine().charAt(0);
		return inputText;
	}

/**
*Read characters, set of valid values.
* @param prompt
* @param validCharacters
* @return
*/
	public char readCharacter(String prompt, String validCharacters) {
		char inputText;
		boolean inputError;
		do {
			inputError = false;
			System.out.println(prompt + ": ");
			inputText = reader.nextLine().toUpperCase().charAt(0);
			if (validCharacters.indexOf(inputText) == -1) {
				inputError = true;
				System.out.println("Character out of range: Please re-enter: ");
			}
			else if (validCharacters.isEmpty() && validCharacters.isBlank()) {
				inputError = true;
				System.out.println("Invalid action. Please re-enter: ");
			}
		} while ( inputError );
		return inputText;
	}

/**
*Identifies blank space & integers in between the String. 
* @param prompt
* @return
*/
	public String readStringOnly(String prompt) {
		String inputText;
		boolean inputError;
		do {
			inputError = false;
			System.out.println(prompt + ": ");

			inputText = reader.nextLine();
			String[] a = inputText.split(inputText);
			for (String c: a) {
				if (c.isBlank() && c.isEmpty()) {
					inputError = true;
					System.out.println("Invalid entry. Please re-enter: ");
				}
			}
			if (inputText.matches(".*\\d.*")) {
				inputError = true;
				System.out.println("Contains integers. Please re-enter: ");
			}
		} while ( inputError );
		return inputText;
	}

/**
*Identifies blank entries.
* @param prompt
* @return
*/
	public String readString(String prompt) {
		String inputText;
		boolean inputError;
		do {
			inputError = false;
			System.out.println(prompt + ": ");

			inputText = reader.nextLine();
			String[] a = inputText.split(inputText);
			for (String c: a) {
				if (c.isBlank()) {
					inputError = true;
					System.out.println("Invalid entry. Please re-enter: ");
				}
			}
		} while ( inputError );
		return inputText;
	}

/**
*Identifies blank entries & if the date contains any Strings.
* @param prompt
* @return
*/
	public String readDate(String prompt) {
		String inputText;
		boolean inputError;
		do {
			inputError = false;
			System.out.println(prompt + ": ");

			inputText = reader.nextLine();
			String[] a = inputText.split(inputText);
			for (String c: a) {
				if (c.isBlank() && c.isEmpty()) {
					inputError = true;
					System.out.println("Invalid entry. Please re-enter: ");
				}
			}
			for (char c: inputText.toCharArray()) {
				if (Character.isAlphabetic(c)) {
					inputError = true;
					System.out.println("Contains alphabets. Please re-enter: ");
				}
			}
		} while ( inputError );
		return inputText;
	}

/**
*Identifies blank entries & if the category does not equal to "FullTime" or "PartTime".
* @param prompt
* @return
*/
	public String readCategory(String prompt) {
		String inputText;
		boolean inputError;
		do {
			inputError = false;
			System.out.println(prompt + ": ");

			inputText = reader.nextLine();
			String[] a = inputText.split(inputText);
			for (String c: a) {
				if (c.isBlank() && c.isEmpty()) {
					inputError = true;
					System.out.println("Invalid entry. Please re-enter: ");
					break;
				}
			}
			if (!inputText.contains("FullTime") && !inputText.contains("PartTime")) {
				inputError = true;
				System.out.println("Invalid entry. Please re-enter: ");
			}
		} while ( inputError );
		return inputText;
	}

/**
*Read int.
* @param prompt
* @param max
* @param min
* @return
*/
	public int readInt(String prompt, int max, int min) {
		int inputNumber = 0;
		boolean inputError;
		do {
			inputError = false;
			System.out.println(prompt + ": ");

			try {
				inputNumber = Integer.parseInt(reader.nextLine());
				if (inputNumber < min || inputNumber > max) {
					inputError = true;
					System.out.println("Number out of range: Please re-enter\n");
				}
			} catch(NumberFormatException e) {
				inputError = true;
				System.out.println("Not a valid number: Please re-enter: ");
			}
		} while ( inputError );
		return inputNumber;
	}

/**
*Read int.
* @param prompt
* @return
*/
	public int readInt(String prompt) {
		int inputNumber = 0;
		boolean inputError;
		do {
			inputError = false;
			System.out.println(prompt + ": ");

			try {
				inputNumber = Integer.parseInt(reader.nextLine());
			} catch(NumberFormatException e) {
				inputError = true;
				System.out.println("Not a valid number: Please re-enter: ");
			}
		} while ( inputError );
		return inputNumber;
	}

/**
*Read float.
* @param prompt
* @return
*/
	public float readFloat(String prompt) {
		float inputNumber = 0.0f;
		boolean inputError;
		do {
			inputError = false;
			System.out.println(prompt + ": ");

			try {
				inputNumber = Float.parseFloat(reader.nextLine());
			} catch(NumberFormatException e) {
				inputError = true;
				System.out.println("Not a valid number: Please re-enter: ");
			}
		} while ( inputError );
		return inputNumber;
	}

}
