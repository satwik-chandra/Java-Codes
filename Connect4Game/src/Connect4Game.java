/* SELF ASSESSMENT

Connect4Game class (35 marks)
My class creates references to the Connect 4 Grid and two Connect 4 Players. It asks the user whether he/she would like to play/quit inside a loop. If the user decides to play then: 1. Connect4Grid2DArray is created using the Connect4Grid interface, 2. the two players are initialised - must specify the type to be ConnectPlayer, and 3. the game starts. In the game, I ask the user where he/she would like to drop the piece. I perform checks by calling methods in the Connect4Grid interface. Finally a check is performed to determine a win. 
Comment:Yes

Connect4Grid interface (10 marks)
I define all 7 methods within this interface.
Comment: Yes

Connect4Grid2DArray class (25 marks) 
My class implements the Connect4Grid interface. It creates a grid using a 2D array Implementation of the method to check whether the column to drop the piece is valid. It provides as implementation of the method to check whether the column to drop the piece is full. It provides as implementation of the method to drop the piece.  It provides as implementation of the method to check whether there is a win.
Comment:yes

ConnectPlayer abstract class (10 marks)
My class provides at lest one non-abstract method and at least one abstract method. 
Comment: yes

C4HumanPlayer class (10 marks)
My class extends the ConnectPlayer claas and overrides the abstract method(s). It provides the Human player functionality.
Comment:yes

C4RandomAIPlayer class (10 marks)
My class extends the ConnectPlayer claas and overrides the abstract method(s). It provides AI player functionality. 
Comment: yes

Total Marks out of 100: 100

*/





//import java.io.InputStreamReader;
//import java.io.BufferedReader;
import java.util.Scanner;

public class Connect4Game {
	public static final int RED = 1;
	public static final int YELLOW = 2;
	public static final int PLAYER_ONE = 0;
	public static final int PLAYER_TWO = 1;

	public static void main(String[] args) throws Exception {
  
		Scanner input = new Scanner(System.in);
		
	
		boolean quit = false;
		while (!quit) {
			boolean invalidInput = false;
			while (!invalidInput) {
				System.out.println("Enter play or quit:");
				String userInput = input.next();
				if (userInput.equals("quit")) {
					quit = true;
					invalidInput = true;
				} else if (userInput.equals("play")) {
					invalidInput = false;
					ConnectPlayer playerOne = null;
					ConnectPlayer playerTwo = null;
					Connect4Grid2DArray grid = new Connect4Grid2DArray();
					
					while (!invalidInput) {
						System.out.println(
								"Enter either: " + "\n (1) for Player vs Player" + "\n (2) for Player vs AI" + "\n (3) for AI vs AI");
						Scanner secondInput = new Scanner(System.in);
						
						if (secondInput.hasNextInt()) {
							int place = secondInput.nextInt();
							String userEnter = "" + place;
							
							if (userEnter.equals("1")) {
								playerOne = new C4HumanPlayer(RED, "Player 1");
								playerTwo = new C4HumanPlayer(YELLOW, "Player 2");
								invalidInput = true;
							} else if (userEnter.equals("2")) {
								playerOne = new C4HumanPlayer(RED, "Player 1");
								playerTwo = new C4RandomAIPlayer(YELLOW, "Player 2");
								invalidInput = true;
							} else if (userEnter.equals("3")) {
								playerOne = new C4RandomAIPlayer(RED, "Player 1");
								playerTwo = new C4RandomAIPlayer(YELLOW, "Player 2");
								invalidInput = true;
							} else {
								System.out.println("Invalid input");
							}
						} else {
							System.out.println("Invalid input");
						}
					}

					int player = PLAYER_TWO;

					while (!grid.didLastPieceConnect4() && !grid.isGridFull()) {
						System.out.println(grid);
						if (player == PLAYER_ONE) {
							player = PLAYER_TWO;
							playerTwo.decideWhereToDrop(grid);
						} else {
							player = PLAYER_ONE;
							playerOne.decideWhereToDrop(grid);
						}
					}

					System.out.println(grid);
					if (grid.didLastPieceConnect4()) {
						if (player == PLAYER_ONE) {
							System.out.println("Player 1 won");
						} else {
							System.out.println("Player 2 won");
						}
					} else {
						System.out.println("The game is a draw");
					}
				}
			}

		}

	}

}