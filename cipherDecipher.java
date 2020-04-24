/* SELF ASSESSMENT

 1. Did I use easy-to-understand meaningful variable names formatted properly (in lowerCamelCase)?

        Mark out of 5:5
        Comment: all my variables are formatted properly

 2. Did I indent the code appropriately?

        Mark out of 5:5
        Comment:  yes, the code is indented properly

 3. Did I write the createCipher function correctly (parameters, return type and function body) and invoke it correctly?

       Mark out of 20:20
        Comment:  the createCypher function has been given correct parameters and is going to return a 2d array and has been invoked correctly

 4. Did I write the encrypt function correctly (parameters, return type and function body) and invoke it correctly?

       Mark out of 20:20  
        Comment:yes the encrypt function has been written correctly which takes the cypher pattern and the message as two parameters and 
        returns the encrypted message

 5. Did I write the decrypt function correctly (parameters, return type and function body) and invoke it correctly?

       Mark out of 20:20  
        Comment: the decrypt function has been formatted accurately which takes encrypted message and the cypher pattern as parameters
        and returns the decrypted message

 6. Did I write the main function body correctly (repeatedly obtaining a string and encrypting it and then decrypting the encrypted version)?

       Mark out of 25:25
        Comment:yes the main function body has been correctly written that it asks for the user input and returns the encrypted and decrypted
        message to the user 

 7. How well did I complete this self-assessment?

        Mark out of 5:5
        Comment: i completed this self assessment with utmost honesty and to the fullest

 Total Mark out of 100 (Add all the previous marks): 100

*/ 



import java.util.Scanner;
import java.util.Random;

public class cipherDecipher {

	public static char[] [] createCypher(char[] []cypher)
	{
		String characters = "abcdefghijklmnopqrstuvwxyz 1234567890-=`~!@#$%^&*()_+[]{};':,./<>?|";
		char[] characters_array = characters.toCharArray();
		for (int index = 0; index<characters_array.length;index++) 
		{
			cypher[index] [0] = characters_array[index];
			cypher[index] [1] = characters_array[index];
		}

		Random generator = new Random();
		for(int index = 0; index< characters_array.length; index++)
		{
			int otherIndex = generator.nextInt(characters_array.length);
			char temporary = cypher[index] [1];
			cypher[index] [1] = cypher[otherIndex] [1];
			cypher[otherIndex] [1] = temporary;
		}

		return cypher;
	}

	public static char[] encrypt(char[] message, char[] [] cypher)
	{
		for (int index = 0; index<message.length; index++)
		{   int secondIndex = 0;
		while(message[index]!= cypher[secondIndex][0])
		{
			secondIndex++;
		}
		message[index] = cypher[secondIndex][1];

		}
		return message;


	}

	public static char[] decrypt(char[] message, char[] [] cypher)
	{

		for (int index = 0; index<message.length; index++)
		{   int secondIndex = 0;
		while(message[index]!= cypher[secondIndex][1])
		{
			secondIndex++;
		}
		message[index] = cypher[secondIndex][0];

		}
		return message;

	}

	public static void main(String[] args) {
		boolean finished = false;
		do
		{
			try {
				char[] [] cypher = new char[67][2];
				cypher = createCypher(cypher);
				Scanner input = new Scanner(System.in);
				System.out.println("\nPlease enter your message:");
				if(input.hasNext("exit"))
				{
					finished = true;
					input.close();
				}
				else if(input.hasNextLine())
				{
					String inputString = input.nextLine();
					String lowerCaseInputString = inputString.toLowerCase();
					char [] message = lowerCaseInputString.toCharArray();

					message = encrypt(message, cypher);
					System.out.println("\nYour encrypted message is:");
					String encrypted = new String( message ); 
					System.out.println(encrypted);

					message = decrypt(message, cypher);
					System.out.println("\nYour decrypted message is:");
					String decrypted = new String( message );
					System.out.println(decrypted);

				}


			}
			catch (ArrayIndexOutOfBoundsException e)
			{
				System.out.println("Error, invalid input.");	
			}
		} while (!finished);




	}

}
