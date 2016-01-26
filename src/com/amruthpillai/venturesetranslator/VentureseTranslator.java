package com.amruthpillai.venturesetranslator;

import java.util.Scanner;

/**
 * 
 * @author Amruth Pillai
 * @description Inhabitants of an alien planet Venturium speak Venturese. It is very similar to English; only there are no vowels. Every instance of a vowel is replaced by v.
 *
 */
public class VentureseTranslator {

	/**
	 * @param args Default Arguments Variable Array
	 */
	public static void main(String[] args) {

		// Creating Scanner Object to Allow User Input from Command Line
		Scanner userInput = new Scanner(System.in);

		// Variables used within the Main Function
		String rawInput;
		String[] inputArray;
		StringBuilder stringBuilder;
		// Flag to check if sentence entered is completely Alphabet-Only
		boolean alphaFlag;

		System.out.println(Messages.getString("VentureseTranslator.welcomeIntro")); //$NON-NLS-1$

		// Loop to allow user multiple tries to enter valid input
		do {
			// Take user input on what is the sentence to be converted
			System.out.println(Messages.getString("VentureseTranslator.inputQuery")); //$NON-NLS-1$
			rawInput = userInput.nextLine();
			alphaFlag = false;

			// If input contains anything other than alphabets or spaces, error will be shown
			if (!isAlphaSpace(rawInput)) {
				System.out.println(Messages.getString("VentureseTranslator.inputError")); //$NON-NLS-1$
				alphaFlag = true;
			}
		} while (alphaFlag);

		// Scanner Object must be closed after Usage
		userInput.close();

		// Split letters of rawInput to String Array Blocks
		inputArray = rawInput.split(Messages.getString("VentureseTranslator.nullChar")); //$NON-NLS-1$

		// Traverse through all elements of inputArray
		for (int i = 0; i < inputArray.length; i++) {
			// If the read character is a vowel (lower case), then replace it with a "v".
			if ((inputArray[i].equals(Messages.getString("VentureseTranslator.ch-a"))) || (inputArray[i].equals(Messages.getString("VentureseTranslator.ch-e"))) || (inputArray[i].equals(Messages.getString("VentureseTranslator.ch-i"))) || (inputArray[i].equals(Messages.getString("VentureseTranslator.ch-o"))) || (inputArray[i].equals(Messages.getString("VentureseTranslator.ch-u")))) //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
				inputArray[i] = Messages.getString("VentureseTranslator.ch-v"); //$NON-NLS-1$
			// If the read character is a vowel (upper case), then replace it with a "V".
			else if ((inputArray[i].equals(Messages.getString("VentureseTranslator.ch-A"))) || (inputArray[i].equals(Messages.getString("VentureseTranslator.ch-E"))) || (inputArray[i].equals(Messages.getString("VentureseTranslator.ch-I"))) || (inputArray[i].equals(Messages.getString("VentureseTranslator.ch-O"))) || (inputArray[i].equals(Messages.getString("VentureseTranslator.ch-U")))) //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
				inputArray[i] = Messages.getString("VentureseTranslator.ch-V"); //$NON-NLS-1$
		}

		// Glue back the array elements into a new StringBuilder
		stringBuilder = new StringBuilder();
		for(String s : inputArray)
			stringBuilder.append(s);

		// Here, we convert the StringBuilder Object into a readable String
		System.out.println(stringBuilder.toString());

	}

	// Here, we use Regular Expression to check if the sentence has only Alphabets and Spaces and no other Characters
	public static boolean isAlphaSpace(String string) {
		return string.matches(Messages.getString("VentureseTranslator.regExpForAlphaSpace")); //$NON-NLS-1$
	}

}
