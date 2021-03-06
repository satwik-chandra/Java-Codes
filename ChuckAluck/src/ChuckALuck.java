
/* SELF ASSESSMENT 

1. ResolveBet

I have correctly defined ResolveBet which takes the bet type (String) and the Wallet object, and a void return type [Mark out of 7: 7].
Comment: Yes. I have defined a function ResolveBet which takes a string and object as the parameter.
My program presents the amount of cash in the wallet and asks the user how much he/she would like to bet [Mark out of 8: 8].
Comment:Yes. My program does this exactly.
My program ensures the bet amount is not greater than the cash in the wallet [Mark out of 5: 5].
Comment: The program checks to make sure the amount is not greater than the cash in the wallet. It does not allow the user to continue if false.
My program creates three Dice objects, rolls them and creates a total variable with a summation of the roll values returned [Mark out of 15: 15]..
Comment:Yes. My program creates three dice objects, rolls them and creates a total variable of the sum of the rolls.
My program determines the winnings by comparing the bet type with the total and comparing the bet type with the dice faces for the triple bet [Mark out of 20:20 ].
Comment: Yes. I made and called other functions to compare the bet type with the total and comparing the bet type with the dice faces.
My program outputs the results (win or loss) and adds the winnings to the wallet if user wins or removes the bet amount from the wallet if the user loses [Mark out of 10:10 ].
Comment:The program will tell you whether you have won or not and let you know how much you won if you did win.

2. Main

I ask the user for the amount of cash he/she has, create a Wallet object and put this cash into it [Mark out of 15: 15]
Comment:Yes. The program will ask the user to enter an amount.
My program loops continuously until the user either enters quit or the cash in the wallet is 0 [Mark out of 5:5 ]
Comment:Yes. The program will only end if you type "quit" or if you have no money left in the wallet.
I ask the user to enter any of the four bet types or quit [Mark out of 5:5 ].
Comment:Yes. The user may ask any of the four bet types or quit.
My program calls resolveBet for each bet type entered [Mark out of 5:5 ].
Comment:My program calls resolveBet for the entered bet.
At the end of the game my program presents a summary message regarding winnings and losses [Mark out of 5:5 ]
Comment:At the end of the game the program will let you know how much you made and lost.

 Total Mark out of 100 (Add all the previous marks):100
*/

import java.util.Scanner;

public class ChuckALuck {

	public static final int STANDARD_ODDS_MULTIPLE = 2;
	public static final int TRIPLE_ODDS_MULTIPLE = 31;
	public static void main(String[] args) {

		boolean quit = false;
		Wallet playerWallet = new Wallet();

		while (!quit) {
			Scanner input = new Scanner(System.in);
			System.out.println("Please enter your amount of cash: ");

			if (input.hasNextDouble()) {
				double playerCash = input.nextDouble();
				if (playerCash > 0) {
					double initialAmount = playerCash;
					playerWallet.put(playerCash);
					while (!quit) {
						System.out.println(
								"Your current wallet balance is: $" + String.format("%.02f", playerWallet.check()));
						System.out.println("Please enter your bet type (Triple,Field,High,Low) or enter quit to end");
						String betType = input.next();
						if (betType.equalsIgnoreCase("quit")) {
							quit = true;
						} else if (validInput(betType)) {

							ResolveBet(betType, playerWallet);
							if (playerWallet.check() == 0)
								quit = true;
						} else {
							System.out.println("Not a valid input!");
						}

						if (quit) {
							System.out.println("You started with: $" + String.format("%.02f", initialAmount)
									+ " and ended with: $" + String.format("%.02f", playerWallet.check())
									+ ", which is a " + (initialAmount < playerWallet.check() ? "profit" : "loss")
									+ " of $" + String.format("%.02f", Math.abs(initialAmount - playerWallet.check())));
						}
					}
				} else {
					System.out.println("Not a valid input");
				}
			} else {
				System.out.println("Not a valid input!");
			}

		}

	}

	public static void ResolveBet(String betType, Wallet wallet) {
		Dice dice1 = new Dice();
		Dice dice2 = new Dice();
		Dice dice3 = new Dice();
		double winnings = 0;
		boolean result = false;

		boolean enoughMoney = false;

		while (!enoughMoney) {
			System.out.println("How much would you like to bet?");
			Scanner input = new Scanner(System.in);
			if (input.hasNextDouble()) {
				double bet = input.nextDouble();
				if (!wallet.get(bet)) {
					System.out.println("You don't have that much money!");
				} else {
					dice1.roll();
					dice2.roll();
					dice3.roll();

					int totalDice = dice1.topFace() + dice2.topFace() + dice3.topFace();

					System.out.println(dice1.toString());
					System.out.println(dice2.toString());
					System.out.println(dice3.toString());

					switch (betType.toUpperCase()) {
					case ("TRIPLE"):
						if (Triple(dice1.topFace(), dice2.topFace(), dice3.topFace())) {
							winnings = bet * TRIPLE_ODDS_MULTIPLE;
							result = true;
						}
						break;
					case ("FIELD"):
						if (Field(dice1.topFace(), dice2.topFace(), dice3.topFace())) {
							winnings = bet * STANDARD_ODDS_MULTIPLE;
							result = true;
						}
						break;
					case ("HIGH"):
						if (High(dice1.topFace(), dice2.topFace(), dice3.topFace())) {
							winnings = bet * STANDARD_ODDS_MULTIPLE;
							result = true;

						}
						break;
					case ("LOW"):
						if (Low(dice1.topFace(), dice2.topFace(), dice3.topFace())) {
							winnings = bet * STANDARD_ODDS_MULTIPLE;
							result = true;

						}
						break;
					}

					System.out.println("The total of the dice are: " + totalDice);
					enoughMoney = true;
					if (result == true) {
						wallet.put(winnings);
						System.out.println("Congradulations, you won!");

					} else {
						System.out.println("Unfortunately you lost");

					}
					System.out.println("Your new updated balance is: $" + String.format("%.02f", wallet.check()));
				}
			} else {
				System.out.println("Not a valid input!");
			}

		}

	}

	public static boolean Triple(int dice1, int dice2, int dice3) {
		if (((dice1 == dice2) && (dice1 == dice3)) && !lowHighTriple(dice1, dice2, dice3))
			return true;
		else
			return false;
	}

	public static boolean Field(int dice1, int dice2, int dice3) {
		int totalDice = dice1 + dice2 + dice3;
		if (totalDice < 8 && totalDice > 12)
			return true;
		else
			return false;
	}

	public static boolean High(int dice1, int dice2, int dice3) {
		int totalDice = dice1 + dice2 + dice3;
		if (totalDice > 10 && !HighTriple(dice1, dice2, dice3))
			return true;
		else
			return false;
	}

	public static boolean Low(int dice1, int dice2, int dice3) {
		int totalDice = dice1 + dice2 + dice3;
		if (totalDice < 11 && !LowTriple(dice1, dice2, dice3))
			return true;
		else
			return false;
	}

	public static boolean HighTriple(int dice1, int dice2, int dice3) {
		boolean highTriple = false;
		if (dice1 == 4 && dice2 == 4 && dice3 == 4)
			highTriple = true;
		else if (dice1 == 5 && dice2 == 5 && dice3 == 5)
			highTriple = true;
		else if (dice1 == 6 && dice2 == 6 && dice3 == 6)
			highTriple = true;
		else
			highTriple = false;
		return highTriple;
	}

	public static boolean LowTriple(int dice1, int dice2, int dice3) {
		boolean lowTriple = false;
		if (dice1 == 1 && dice2 == 1 && dice3 == 1)
			lowTriple = true;
		else if (dice1 == 2 && dice2 == 2 && dice3 == 2)
			lowTriple = true;
		else if (dice1 == 3 && dice2 == 3 && dice3 == 3)
			lowTriple = true;
		else
			lowTriple = false;
		return lowTriple;
	}

	public static boolean lowHighTriple(int dice1, int dice2, int dice3) {
		boolean lowHighTriple = false;
		if (dice1 == 1 && dice2 == 1 && dice3 == 1)
			lowHighTriple = true;
		else if (dice1 == 6 && dice2 == 6 && dice3 == 6)
			lowHighTriple = true;
		else
			lowHighTriple = false;
		return lowHighTriple;
	}

	public static boolean validInput(String word) {
		if (word.equalsIgnoreCase("triple") || word.equalsIgnoreCase("field") || word.equalsIgnoreCase("high")
				|| word.equalsIgnoreCase("low") || word.equalsIgnoreCase("quit"))
			return true;
		else
			return false;

	}

	public static boolean validDouble(double number) {
		if (number > 0)
			return true;
		else
			return false;
	}
}
