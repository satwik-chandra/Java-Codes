public interface Connect4Grid 
{
	public void emptyGrid();
	public String toString();
	public boolean isValidColumn(int column);
	public boolean checkColoumn(int column);
	public void dropPiece(ConnectPlayer player, int column);
	public boolean didLastPieceConnect4();
	public boolean isGridFull() ;  
}