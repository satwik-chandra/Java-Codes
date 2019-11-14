/* SELF ASSESSMENT
   1. Did I use appropriate CONSTANTS instead of numbers within the code?
       Mark out of 5:5
       Comment:yes i have used "number of rounds" as a constant
   2. Did I use easy-to-understand, meaningful CONSTANT names formatted correctly in UPPERCASE?
       Mark out of 5:5
       Comment: my constant names are meaningful and formatted correctly in UPPERCASE
   3. Did I use easy-to-understand meaningful variable names?
       Mark out of 10:10
       Comment: my variable names are easy to understand and descriptive
   4. Did I format the variable names properly (in lowerCamelCase)?
       Mark out of 5:5
       Comment: yes i formatted the variable names properly (in lowerCamelCase)
   5. Did I indent the code appropriately?
       Mark out of 10:10
       Comment: yes i have indented the code properly
   6. Did I use an appropriate loop to allow the user to enter their guesses until they win or lose?
       Mark out of 20: 20
       Comment: i only have one while loop to allow the user to enter their guesses until they win or lose(after 4 rounds)
   7. Did I check the input to ensure that invalid input was handled appropriately?
       Mark out of 10: 10
       Comment: yes i check the input to ensure that a valid input was added by the user
   8. Did I generate the cards properly using random number generation (assuming all cards are equally likely each time)?
       Mark out of 10: 10
       Comment: yes i use the random integer generator to pick a random card
   9. Did I output the cards correctly as 2, 3, 4, ... 9, 10, Jack, Queen, King?
       Mark out of 10: 10
       Comment: yes i output the cards correctly
   10. Did I report whether the user won or lost the game before the program finished?
       Mark out of 10:10
       Comment: yes i report whether the user won or lost the game before the program finished
   11. How well did I complete this self-assessment?
       Mark out of 5:5
       Comment: with utmost honesty
   Total Mark out of 100 (Add all the previous marks): 100
 */

import javax.swing.JOptionPane;
import java.util.Random;
public class HighLowGame {

	public static void main(String[] args) {
		Random rand = new Random();
		final int NUMBER_OF_ROUNDS = 4;
		int count = 0;
		int points  = 0;

		int firstCard = rand.nextInt(13)+2;
		String firstCardName = "";
		switch(firstCard)
		{
		case 2: firstCardName = "2"; break;
		case 3: firstCardName = "3"; break;
		case 4: firstCardName = "4"; break;
		case 5: firstCardName = "5"; break;
		case 6: firstCardName = "6"; break;
		case 7: firstCardName = "7"; break;
	
		
		case 8: firstCardName = "8"; break;
		case 9: firstCardName = "9"; break;
		case 10: firstCardName = "10"; break;
		case 11: firstCardName = "Jack"; break;
		case 12: firstCardName = "Queen"; break;
		case 13: firstCardName = "King"; break;
		case 14: firstCardName = "Ace"; break;


		}

		JOptionPane.showMessageDialog(null,"The card is a " + firstCardName);



		while(count < NUMBER_OF_ROUNDS)
		{



			String secondCardAssumption = JOptionPane.showInputDialog(null,"Do you think the next card will be higher, lower or equal?");
			if((secondCardAssumption.toLowerCase()).equals("higher") || (secondCardAssumption.toLowerCase()).equals("lower") || (secondCardAssumption.toLowerCase()).equals("equal"))
			{

				int secondCard = rand.nextInt(13)+2;
				String secondCardName = "";
				switch(secondCard)
				{
				case 2: secondCardName = "2"; break;
				case 3: secondCardName = "3"; break;
				case 4: secondCardName = "4"; break;
				case 5: secondCardName = "5"; break;
				case 6: secondCardName = "6"; break;
				case 7: secondCardName = "7"; break;
				case 8: secondCardName = "8"; break;
				case 9: secondCardName = "9"; break;
				case 10: secondCardName = "10"; break;
				case 11: secondCardName = "Jack"; break;
				case 12: secondCardName = "Queen"; break;
				case 13: secondCardName = "King"; break;
				case 14: secondCardName = "Ace"; break;
				}



				if((secondCardAssumption.toLowerCase()).equals("higher") && secondCard>firstCard)
				{
					points+=1;

				}

				if((secondCardAssumption.toLowerCase()).equals( "lower") && secondCard<firstCard)
				{
					points+=1;
				}

				if((secondCardAssumption.toLowerCase()).equals("equal") && secondCard==firstCard)
				{
					points+=1;
				}

				firstCard = secondCard;
				count++;


				JOptionPane.showMessageDialog(null,"The card is a " + secondCardName);
			}
			else
			{

				JOptionPane.showMessageDialog(null, "Sorry you have lost the game since you have entered a Wrong Input!");
				break;
			}

		}


		JOptionPane.showMessageDialog(null,"Your points are " + points +" out of 4");

		if(points == 4)
		{
			JOptionPane.showMessageDialog(null,"Congratulations.  You got them all correct.");
		}
		else
		{
			JOptionPane.showMessageDialog(null,"Sorry, you lost!, you needed to get all of them correct. Better luck next time!");
		}





	}

}
