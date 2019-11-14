
/* SELF ASSESSMENT
   1. Did I use appropriate easy-to-understand, meaningful variables and CONSTANTS within the code? 
       Mark out of 10:10
       Comment: Yes I used easy to understand variable names that are descriptive 
   2. Did I format the variable and CONSTANT names appropriate (in lowerCamelCase and UPPERCASE)?
       Mark out of 5:5
       Comment: Yes all of my variables are in lowerCamelCase
   3. Did I generate the computer's choice in each game correctly using a Random number generator?
       Mark out of 10: 10
       Comment: Random number generator is used correctly
   4. Did I input the user's choice in each game correctly?
       Mark out of 10: 10
       Comment: Yes user's input is taken accurately and if the input is wrong then the user is notified for it
   5. Did I correctly compare the choices and update the score appropriately?
       Mark out of 20: 20
       Comment: The choices are compared accurately and then the score is updated accordingly
   6. Did I inform the user of who won each game (and why) correctly?
       Mark out of 10: 10
       Comment: Yes I inform the user of who won each game (and why) correctly
   7. Did I use an appropriate for loop to allow the player to play 5 games?  There should be only one loop.
       Mark out of 20: 20
       Comment: yes i have only used one loop(for loop) that works for 5 rounds
   8. Did I output the final scores correctly after the 5 games were played. 
       Mark out of 10: 10
       Comment: Yes the output is shown correctly after the 5 games are played showing the scores of both user and the computer 
   9. How well did I complete this self-assessment?
       Mark out of 5: 5
       Comment: I have completed the self assessment to the fullest and with utmost honesty
   Total Mark out of 100 (Add all the previous marks): 100
*/


import javax.swing.*;
import java.util.Random;
public class RockPaperScissors {

	public static void main(String[] args) {
		Random  generator = new Random();
		int computerHand = 0;
		int userHand = 0;
		int userPoints = 0;
		int computerPoints = 0;
		for(int rounds = 5;rounds!=0;rounds--)
		{
			computerHand = generator.nextInt(3)+1;
			String userHandInput = JOptionPane.showInputDialog(null, "Enter 1 (for Rock) or 2 (for Paper) or 3 (for Scissors): ");
			userHand = Integer.parseInt(userHandInput);


			if (computerHand == 1 && userHand == 1)
			{
				JOptionPane.showMessageDialog(null,"This round was a draw as I chose Rock too!");

			}

			else if (computerHand == 1 && userHand == 2)
			{
				JOptionPane.showMessageDialog(null,"You won this round as I chose Rock!");
				userPoints += 1;
			}

			else if (computerHand == 1 && userHand == 3)
			{
				JOptionPane.showMessageDialog(null,"You lost this round as I chose Rock");
				computerPoints += 1;
			}

			else if (computerHand == 2 && userHand == 1)
			{
				JOptionPane.showMessageDialog(null,"You lost this round as I chose Paper!");
				computerPoints += 1;
			}

			else if (computerHand == 2 && userHand == 2)
			{
				JOptionPane.showMessageDialog(null,"This round was a draw as I chose Paper too!");
			}

			else if (computerHand == 2 && userHand == 3)
			{
				JOptionPane.showMessageDialog(null,"You won this round as I chose Paper!");
				userPoints += 1;
			}

			else if (computerHand == 3 && userHand == 1)
			{
				JOptionPane.showMessageDialog(null,"You won this round as I chose Scissors!");
				userPoints += 1;
			}

			else if (computerHand == 3 && userHand == 2)
			{
				JOptionPane.showMessageDialog(null,"You lost"
						+ " this round as I chose Scissors!");
				computerPoints += 1;
			}

			else if (computerHand == 3 && userHand == 3)
			{
				JOptionPane.showMessageDialog(null,"This round was a draw as I chose Scissors too!");
			}
			else
			{
				JOptionPane.showMessageDialog(null,"You have entered an invalid input, input should be any one of 1,2, or 3");
			}


		}
		JOptionPane.showMessageDialog(null, "The final score was Computer:"+computerPoints+ " User:"+ userPoints );

	}

}
