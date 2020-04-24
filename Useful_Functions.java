import java.util.Scanner;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JCheckBox;
import javax.swing.UIManager;
import java.util.Arrays;
import java.util.Collections;

public class Useful_Functions
{	
	
	/*
		public static void main(String[] args) 
		{
			try
			{
			
			}
			catch (ArithmeticException e)
			{
				JOptionPane.showMessageDialog(null, "Invalid number inputted." , "Error", JOptionPane.INFORMATION_MESSAGE);
			}
			catch (java.util.NoSuchElementException e)
			{
				JOptionPane.showMessageDialog(null, "User did not input anything." , "Error", JOptionPane.INFORMATION_MESSAGE);
			}
			catch (NullPointerException e)
			{
				JOptionPane.showMessageDialog(null, "User left the window." , "Error", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	*/
	
	//////////////////////////////////USER INPUT////////////////////////////////////////////////////////////////////
	
	/* 
	 	String inputTitle = "Title";
		String inputText = "Body";
		String example = getNext(inputText, inputTitle);
	*/
	
	private static String getNext(String inputText, String inputTitle)
	{
		String userInput = JOptionPane.showInputDialog(null,inputText, inputTitle, JOptionPane.INFORMATION_MESSAGE);
		return userInput;
	}
	
	
	
	//////////////////////////////////INTEGERS////////////////////////////////////////////////////////////////////
	
	/* 
	 	String inputTitle = "Title";
		String inputText = "Body";
		int example = getNextPositiveInt(inputText, inputTitle);
	 */
	
	/*
		//////////number of digits of an integer/////////
		int inputX = (int) inputA; //type cast
		Integer.pargeInt(double);
		int length = Integer.toString(inputX).length();
	*/
	
	private static int getNextPositiveInt(String inputText, String inputTitle)
	{			
		Scanner input = new Scanner(getNext(inputText, inputTitle));
		String testString = input.next();
		if (checkIfInt(testString))
		{
			int testInt = Integer.parseInt(testString);
			if (testInt > 0)
			{
				input.close();
				return testInt;
			}
			else
			{
				input.close();
				throw new ArithmeticException("Integer is negative");
			}
		}
		else
		{
			input.close();
			throw new ArithmeticException("Integer not found");
		}
	}
	
	private static boolean checkIfInt(String input)
	{
		 try 
	        { 
	            Integer.parseInt(input); 
	            return true;
	        }  
	        catch (NumberFormatException e)  
	        { 
	            return false;
	        } 
	}
	
	
	
	//////////////////////////////////DOUBLES////////////////////////////////////////////////////////////////////
	
	/* 
	 	String inputTitle = "Title";
		String inputText = "Body";
		double example = getNextPositiveDouble(inputText, inputTitle);
	 */
	private static double getNextPositiveDouble(String inputText, String inputTitle)
	{			
		Scanner input = new Scanner(getNext(inputText, inputTitle));
		String testString = input.next();
		if (checkIfDouble(testString))
		{
			double testDouble = Double.parseDouble(testString);
			if (testDouble> 0)
			{
				input.close();
				return testDouble;
			}
			else
			{
				input.close();
				throw new ArithmeticException("Double is negative");
			}
		}
		else
		{
			input.close();
			throw new ArithmeticException("Double not found");
		}
	}
	
	private static boolean checkIfDouble(String input)
	{
		 try 
	        { 
	            Double.parseDouble(input); 
	            return true;
	        }  
	        catch (NumberFormatException e)  
	        { 
	            return false;
	        } 
	}
	
	
	
	//////////////////////////////////STRING ANALYSIS////////////////////////////////////////////////////////////////////
	
	private static boolean checkIfYes(String input)
	{
		if (input.contentEquals("yes"))
		{
			return true;
		}
		else if (input.contentEquals("YES"))
		{
			return true;
		}
		else if (input.contentEquals("Yes"))
		{
			return true;
		}
		return false;
	}
	
	private static boolean checkIfNo(String input)
	{
		if (input.contentEquals("no"))
		{
			return true;
		}
		else if (input.contentEquals("NO"))
		{
			return true;
		}
		else if (input.contentEquals("No"))
		{
			return true;
		}
		return false;
	}
	
	
	
	//////////////////////////////////ARRAYS////////////////////////////////////////////////////////////////////
	
	/*	/////Array Basics/////
		array.reverse();
		array.clone();
	*/
	private static String[] splitStringIntoArray(String input, String delimeter)
	{
		String[] array = input.split(delimeter);
		return array;
		/*
			delimeter = " "		space
			delimeter = "\\.";	fullstop
			delimeter = "\\|";	vertical line
			delimeter = "-";	dash
			
			/////limits the amount of substrings (will only split at first delimeter)/////
			String[] array = input.split(delimeter, 2);
		*/
	}
	
	private static boolean arrayNotEmpty(String array[])
	{
		return (array != null && array.length != 0);
	}
	
	private static void printArray(String array[])
	{
		System.out.print(Arrays.toString(array));
	}
	
	private static void printArrayWithoutBrackets(String array[])
	{
		System.out.print(array[0]);
		for(int position=1; position < array.length ; position++)
		{
			System.out.print(", " + array[position]);
		}
	}
	
	private static void printToJOptionPane(String array[], String Title, String Text)
	{
		String stringToPrint = "";
		for(int position=0; position < array.length; position++)
		{
			stringToPrint += array[position] + " ";
		}
		JOptionPane.showMessageDialog(null, Text + "\n" + stringToPrint , Title, JOptionPane.INFORMATION_MESSAGE);
	}
	
	private static void removeOddNumbersFromArray(int array[])
	{
		array = Arrays.stream(array).filter(value -> value % 2 == 0).toArray();
	}
	
	private static void removeEvenNumbersFromArray(int array[])
	{
		array = Arrays.stream(array).filter(value -> value % 2 != 0).toArray();
	}
	
	private static String[] combineArrays(String array1[], String array2[])
	{
		int array1Length = array1.length;
		int array2Length = array2.length;
		String[] combined = new String [array1Length + array2Length];
		System.arraycopy(array1, 0, combined, 0, array1Length);
		System.arraycopy(array2, 0, combined, array1Length, array1Length);
		return combined;
	}
	
	private static void initialiseArrayToValue(double array[], double valueToInitilaise)
	{
		for(int position=0; position < array.length; position++)
		{
			array[position] = valueToInitilaise;
		}
	}
	
	private static int findPositionOfValueInArray(double array[], double valueToFind)
	{
		int testPosition = (array.length - 1);
		for(int position=0; position < array.length ; position++)
		{
			double testNumber = array[testPosition];
			if (testNumber == valueToFind)
			{
				return testPosition;
			}
			testPosition--;
		}
		return -1;
	}
	
	private static void extendArray(String array[], int amountToExtend)
	{
		//must declare array as static and use real name
		String[] temp = array.clone();
		array = new String[array.length + amountToExtend];
		System.arraycopy(temp,  0,  array, 0, temp.length);
	}
	
	private static void addToEndOfArray(String array[], String valueToAdd)
	{
		extendArray(array, 1);
		array[array.length - 1] = valueToAdd;
	}
	
	private static boolean compareArrays(String array1[], String array2[])
	{
		return Arrays.deepEquals(array1, array2);
	}
	
	private static void shuffleArray(String array[])
	{
		Random generator = new Random();
		for(int position=0; position < array.length ; position++)
		{
			int randomIndexToSwap = generator.nextInt(array.length);
			String temp = array[randomIndexToSwap];
			array[randomIndexToSwap] = array[position];
			array[position] = temp;
		}
	}
	
	private static void sortArrayAscendingAll(String array[])
	{
		Arrays.sort(array);
	}
	
	private static void sortArrayDescendingALL(String array[])
	{
		Arrays.sort(array, Collections.reverseOrder());
	}
	
	private static void sortArrayAscendingSelected(String array[], int startNumber, int endNumber)
	{
		Arrays.sort(array, startNumber, endNumber);
	}
	
	private static void sortArrayDescendingSelected(String array[], int startNumber, int endNumber)
	{
		Arrays.sort(array, startNumber, endNumber, Collections.reverseOrder());
	}

	private static int positionOfLowestValueInArray(double array[])
	{
		int amountToCheck = (array.length - 1);
		int lastPosition = (array.length - 1);
		int positionOfLowest = lastPosition;
		int testPosition1 = lastPosition;
		int testPosition2 = --lastPosition;
		if (testPosition1 == 0)
		{
			return 0;
		}
		for(int position=0; position < amountToCheck ; position++)
		{
			double testNumber1 = array[testPosition1];
			double testNumber2 = array[testPosition2];
			if (testNumber1 > testNumber2)
			{
				positionOfLowest = testPosition2;
			}
			testPosition1--;
			testPosition2--;
		}
		return positionOfLowest;
	}
	
	private static int countAmoutAboveOrEqualToValueInArray(double array[], double valueToBeAboveOrEqual)
	{
		int amountToCheck = (array.length - 1);
		int lastPosition = (array.length - 1);
		int amountAboveValue = 0;
		int testPosition1 = lastPosition;
		if (testPosition1 == 0)
		{
			return 0;
		}
		for(int position=0; position < amountToCheck ; position++)
		{
			double testNumber1 = array[testPosition1];
			if (testNumber1 >= valueToBeAboveOrEqual)
			{
				amountAboveValue++;
			}
			testPosition1--;
		}
		return amountAboveValue;
	}
	
	private static int countAmoutBelowOrEqualToValueInArray(double array[], double valueToBeBelowOrEqual)
	{
		int amountToCheck = (array.length - 1);
		int lastPosition = (array.length - 1);
		int amountAboveValue = 0;
		int testPosition1 = lastPosition;
		if (testPosition1 == 0)
		{
			return 0;
		}
		for(int position=0; position < amountToCheck ; position++)
		{
			double testNumber1 = array[testPosition1];
			if (testNumber1 <= valueToBeBelowOrEqual)
			{
				amountAboveValue++;
			}
			testPosition1--;
		}
		return amountAboveValue;
	}
	
	private static int countAmoutAboveValueInArray(double array[], double valueToBeAbove)
	{
		int amountToCheck = (array.length - 1);
		int lastPosition = (array.length - 1);
		int amountAboveValue = 0;
		int testPosition1 = lastPosition;
		if (testPosition1 == 0)
		{
			return 0;
		}
		for(int position=0; position < amountToCheck ; position++)
		{
			double testNumber1 = array[testPosition1];
			if (testNumber1 > valueToBeAbove)
			{
				amountAboveValue++;
			}
			testPosition1--;
		}
		return amountAboveValue;
	}
	
	private static int countAmoutBelowValueInArray(double array[], double valueToBeBelow)
	{
		int amountToCheck = (array.length - 1);
		int lastPosition = (array.length - 1);
		int amountAboveValue = 0;
		int testPosition1 = lastPosition;
		if (testPosition1 == 0)
		{
			return 0;
		}
		for(int position=0; position < amountToCheck ; position++)
		{
			double testNumber1 = array[testPosition1];
			if (testNumber1 < valueToBeBelow)
			{
				amountAboveValue++;
			}
			testPosition1--;
		}
		return amountAboveValue;
	}
	
	private static int positionOfHighestValueInArray(double array[])
	{
		int amountToCheck = (array.length - 1);
		int lastPosition = (array.length - 1);
		int positionOfLowest = lastPosition;
		int testPosition1 = lastPosition;
		int testPosition2 = --lastPosition;
		if (testPosition1 == 0)
		{
			return 0;
		}
		for(int position=0; position < amountToCheck ; position++)
		{
			double testNumber1 = array[testPosition1];
			double testNumber2 = array[testPosition2];
			if (testNumber1 < testNumber2)
			{
				positionOfLowest = testPosition2;
			}
			testPosition1--;
			testPosition2--;
		}
		return positionOfLowest;
	}
	
	private static int countFrequencyOfValueInArray(double array[], double valueToCheck)
	{
		int frequencyOfValue = 0;
		boolean valueStillPresent = true;
		int firstPosition = 0;
		Arrays.sort(array);
		int PositionOfValue = findPositionOfValueInArray(array, valueToCheck);
		if (PositionOfValue != -1)
		{
			frequencyOfValue = 1;
			while (valueStillPresent)
			{
				if (PositionOfValue - 1 >= firstPosition && array[PositionOfValue] == array[PositionOfValue - 1])
				{
					frequencyOfValue++;
					PositionOfValue--;
				}
				else
				{
					valueStillPresent = false;
				}
			}
		}
		return frequencyOfValue;
	}
	
	
	
	//////////////////////////////////RANDOM NUMBER GENERATOR////////////////////////////////////////////////////////////////////
	
	public static final int MAX_NUMBER = 3;
	Random generator = new Random();
	int randomNumber = generator.nextInt(MAX_NUMBER);
	
	
	
	//////////////////////////////////JOPTIONPANE////////////////////////////////////////////////////////////////////
	
	//true or false
	int answer = JOptionPane.showConfirmDialog(null, "question");
	boolean variable = (answer == JOptionPane.YES_OPTION);
	
	//label options
	String[] stringOptions = {"Label1", "Label2", "Label3", "Label4"};
	Integer[] integerOptions = {1, 2, 3, 4};
	Double[] doubleOptions = {1.1, 2.2, 3.3, 4.4};
	Character[] characherOptions = {'a', 'b', 'c', 'd'};
	JCheckBox check = new JCheckBox("Label");
	Object[] objectOptions = {"Label", 1, 1.1, 'a', check};
	int x = JOptionPane.showOptionDialog(null, "Label", "Title", JOptionPane.DEFAULT_OPTION, 
			JOptionPane.INFORMATION_MESSAGE, null, stringOptions, stringOptions[0]);	//x = position of answer in array
	/*
	if (check.isSelected() && x != -1) //checks if tick entered and that user didn't exit
	{
		System.out.print("Your choice was " + stringOptions[x]);
	}
	*/
	
	//label options alternative
	public static void main(String[] args) 
	{	
		String test = "";
		String inputText =  "";
		String inputTitle =  "";
		int lengthOfArray = 5;
		int startNumber = 1; 
		int endNumber = 5;
		String[] array = new String[lengthOfArray];
		double[] arrayDouble = new double[lengthOfArray];
		int[] arrayInt = new int[lengthOfArray];
		double valueToInitilaise = 1;
		double valueToFind = 1;
		int amountToExtend = 1;
		String valueToAdd = "";
		checkIfNo(test);
		getNextPositiveInt(inputText, inputTitle);
		getNextPositiveDouble(inputText, inputTitle);
		checkIfYes(test);
		printArray(array);
		shuffleArray(array);
		initialiseArrayToValue(arrayDouble, valueToInitilaise);
		findPositionOfValueInArray(arrayDouble, valueToFind);
		compareArrays(array, array);
		extendArray(array, amountToExtend);
		addToEndOfArray(array, valueToAdd);
		sortArrayAscendingAll(array);
		sortArrayDescendingALL(array);
		sortArrayAscendingSelected(array, startNumber, endNumber);
		sortArrayDescendingSelected(array, startNumber, endNumber);
		positionOfLowestValueInArray(arrayDouble);
		positionOfHighestValueInArray(arrayDouble);
		arrayNotEmpty(array);
		removeOddNumbersFromArray(arrayInt);
		removeEvenNumbersFromArray(arrayInt);
		combineArrays(array, array);
		countAmoutAboveOrEqualToValueInArray(arrayDouble, valueToFind);
		countAmoutBelowOrEqualToValueInArray(arrayDouble, valueToFind);
		countAmoutAboveValueInArray(arrayDouble, valueToFind);
		countAmoutBelowValueInArray(arrayDouble, valueToFind);
		countFrequencyOfValueInArray(arrayDouble, valueToFind);
		splitStringIntoArray(inputText, inputTitle);
		printArrayWithoutBrackets(array);
		printToJOptionPane(array, inputTitle, inputText);
		
		
	///////////////////////////////////////////////////////////////////////////
		UIManager.put("OptionPane.yesButtonText", "Rock");
		UIManager.put("OptionPane.noButtonText", "Paper");
		UIManager.put("OptionPane.cancelButtonText", "Scissors");
	}
	
	int userChoice = JOptionPane.showConfirmDialog(null,"Make your selection", "Can you beat the computer?",
			JOptionPane.YES_NO_CANCEL_OPTION);
}
