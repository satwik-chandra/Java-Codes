public  class Connect4Grid2DArray implements Connect4Grid
{
	public static final int NUMBER_OF_ROWS = 6;
	public static final int NUMBER_OF_COLOUMNS = 7;
	private static final int EMPTY = 0;
	private static final int RED = 1;
	private static final int YELLOW = 2;
	private static final int NOT_INITIALIZED = -1;
	private static final int FILLED_CELLS_TO_WIN = 3;
	private int[][] grid; 
	private int[] lastEmptyIndex;
	private int lastColumn;
	
	public Connect4Grid2DArray()
	{
		grid = new int[NUMBER_OF_ROWS][NUMBER_OF_COLOUMNS];
		lastEmptyIndex = new int[NUMBER_OF_COLOUMNS];
		emptyGrid();
	}
	
	public void emptyGrid()
	{
		for(int rowIndex = 0 ;rowIndex < NUMBER_OF_ROWS; rowIndex++)
		{
			for(int coloumnIndex = 0; coloumnIndex < NUMBER_OF_COLOUMNS;coloumnIndex++)
			{
				grid[rowIndex][coloumnIndex] = EMPTY;
			}
		}
		
		for(int index = 0; index< NUMBER_OF_COLOUMNS;index++)
		{
			lastEmptyIndex[index] = NUMBER_OF_ROWS - 1;
		}
		
		lastColumn = NOT_INITIALIZED;
	}
	
	public String toString()
	{
		String gridString ="";
		
		for(int rowIndex = 0;rowIndex<NUMBER_OF_ROWS;rowIndex++)
		{
			for(int coloumnIndex = 0;coloumnIndex<NUMBER_OF_COLOUMNS;coloumnIndex++)
			{
				switch(grid[rowIndex][coloumnIndex])
				{
				case EMPTY: 
					gridString = gridString +"0 ";
					break;
				case RED:  
					gridString = gridString +"R ";
					break;
				case YELLOW:  
					gridString = gridString +"Y ";
					break;
				default: break;
				}
			}
			gridString = gridString +"\n";
		}
		
		
		return "Grid:\n1 2 3 4 5 6 7\n" + gridString+"1 2 3 4 5 6 7\n" +"0 - empty, R - red, Y - yellow\n";		
	}
	
	public boolean isValidColumn (int column)
	{
		if(column>=0&&column<=NUMBER_OF_COLOUMNS-1)
			return true;
		else
			return false;
	}
	
	public boolean checkColoumn(int column)
	{
		
		if(isValidColumn(column))
		{
			return lastEmptyIndex[column]<0;
		}
		else
		{
			return true;
		}
				
	}
	
	public void dropPiece(ConnectPlayer player, int column)
	{
		if(!checkColoumn(column))
		{
			int colour = player.getPlayerColour();
			grid[lastEmptyIndex[column]][column] = colour;
			lastEmptyIndex[column]--;
			lastColumn = column;
			
		}
	}
	
	public boolean didLastPieceConnect4()
	{
		if(lastColumn != NOT_INITIALIZED)
		{
			
			
			int lastRow = lastEmptyIndex[lastColumn] + 1;
			int colour = grid[lastRow][lastColumn];
			boolean rightMostColoumn = lastColumn + FILLED_CELLS_TO_WIN <= NUMBER_OF_COLOUMNS -1;
			boolean leftMostColooumn = lastColumn - FILLED_CELLS_TO_WIN >=0;
			boolean topRow = lastRow - FILLED_CELLS_TO_WIN >=0;
			boolean bottomRow = lastRow + FILLED_CELLS_TO_WIN <= NUMBER_OF_ROWS -1;
			
			
			
			if(topRow)
			{
				if(colour == grid[lastRow - 1][lastColumn]&&
						colour == grid[lastRow - 2][lastColumn]&&
							colour == grid[lastRow - 3][lastColumn])
				{
					return true;
				}
			}
		
			if(bottomRow)
			{
				if(colour == grid[lastRow + 1][lastColumn]&&
						colour == grid[lastRow + 2][lastColumn]&&
							colour == grid[lastRow + 3][lastColumn])
				{
					return true;
				}
			}
			
			if(leftMostColooumn)
			{
				if(colour == grid[lastRow][lastColumn - 1]&&
						colour == grid[lastRow][lastColumn - 2]&&
							colour == grid[lastRow][lastColumn - 3])
				{
					return true;
				}
			}
	
			if(rightMostColoumn)
			{
				if(colour == grid[lastRow][lastColumn + 1]&&
						colour == grid[lastRow][lastColumn + 2]&&
							colour == grid[lastRow][lastColumn + 3])
				{
					return true;
				}
			}
			
			if(leftMostColooumn&&topRow)
			{
				if(colour == grid[lastRow - 1][lastColumn - 1]&&
						colour == grid[lastRow - 2][lastColumn - 2]&&
							colour == grid[lastRow - 3][lastColumn - 3])
				{
					return true;
				}
			}
			
			if(rightMostColoumn&&topRow)
			{
				if(colour == grid[lastRow - 1][lastColumn + 1]&&
						colour == grid[lastRow - 2][lastColumn + 2]&&
							colour == grid[lastRow - 3][lastColumn + 3])
				{
					return true;
				}
			}
			
			if(leftMostColooumn&&bottomRow)
			{
				if(colour == grid[lastRow + 1][lastColumn - 1]&&
						colour == grid[lastRow + 2][lastColumn - 2]&&
							colour == grid[lastRow + 3][lastColumn - 3])
				{
					return true;
				}
			}
			
			if(rightMostColoumn&&bottomRow)
			{
				if(colour == grid[lastRow + 1][lastColumn + 1]&&
						colour == grid[lastRow + 2][lastColumn + 2]&&
							colour == grid[lastRow + 3][lastColumn + 3])
				{
					return true;
				}
			}
			
			return false;				
		}
		else
		{
			return false;
		}
	}
	
	public boolean isGridFull() 
	{
		for(int index = 0 ;index<NUMBER_OF_COLOUMNS;index++)
		{
			if(!checkColoumn(index))
			{
				return false;
			}
		}
		
		return true;
	}

}