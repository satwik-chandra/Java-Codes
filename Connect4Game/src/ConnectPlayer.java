public abstract class ConnectPlayer 
{
	private int playerColour;
	private String playerName;
	protected static final int RED = 1;
	protected static final int YELLOW = 2;
	
	public ConnectPlayer(int playerColour,String playerName)
	{
		this.playerColour = playerColour;
		this.playerName = playerName;
	}
	
	public int getPlayerColour()
	{
		return playerColour;
	}
	
	public void setPlayerColour(int playerColour)
	{
		if(playerColour==RED||playerColour==YELLOW)
		{
			this.playerColour = playerColour;
		}
	}
	
	public String getColorName()
	{
		switch(playerColour)
		{
		case RED: 
			return "RED";
		case YELLOW: 
			return "YELLOW";
		default: 
			return "ERROR";
		}
	}
	
	public String getPlayerName()
	{
		return playerName;
	}
	
	public void setPlayerName(String name)
	{
		playerName = name;
	}
		
	public String toString()
	{
		return "[playerColour = "+ getColorName()+ ",playerName = " +getPlayerName() + "]";
	}
	
	public boolean integerTryParse(String line) 
	{  
		  try 
		  {  
	         Integer.parseInt(line);  
	         return true;  
	      } 
		  catch (Exception e) 
		  {  
	         return false;  
	      }  
	}
	
	abstract public void decideWhereToDrop(Connect4Grid2DArray grid) throws Exception;
		
}