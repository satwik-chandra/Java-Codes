import java.util.ArrayList;
import java.util.Random;
public class C4RandomAIPlayer extends ConnectPlayer
{
	public  C4RandomAIPlayer (int colour, String name)
	{
		super(colour, name);
	}
	
	public void decideWhereToDrop(Connect4Grid2DArray grid) 
	{
		ArrayList<Integer> coloumnList = new ArrayList<Integer>();
		for(int index = 0; index < Connect4Grid2DArray.NUMBER_OF_COLOUMNS;index++)
		{
			if(!grid.checkColoumn(index))
			{
				coloumnList.add(index);
			}
		}
		Random randomNumber = new Random();
		int coloumn = coloumnList.get(Math.abs(randomNumber.nextInt()%coloumnList.size()));
		grid.dropPiece(this, coloumn);	
		System.out.println(getPlayerName()+ " (AI) dropped at position " + coloumn);
	}
}