import java.io.InputStreamReader;
import java.io.BufferedReader;
public class C4HumanPlayer extends ConnectPlayer
{
	public C4HumanPlayer(int color, String name)
	{
		super(color,name);
	}
	
	@Override
	public void decideWhereToDrop(Connect4Grid2DArray grid) throws Exception
	{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		boolean enteredCorrectly = false;
		
		while(!enteredCorrectly)
		{
			System.out.println(this.getPlayerName()+", Enter a number between 1 and 7 to insert your colour(Player 1 = Red, Player 2 = Yellow): ");
			String line = input.readLine();
			if(integerTryParse(line))
			{
				int column = Integer.parseInt(line)-1;
				if(!grid.checkColoumn(column))
				{
				
					grid.dropPiece(this, column);
					enteredCorrectly = true;	
				}
				
			}
			
			
		}
	}
}