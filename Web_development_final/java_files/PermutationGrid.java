package toughPuzzles;

public class Grid extends Function {
	int[][] Grid;
	int rows;
	int columns;
	/*README
	This class is a mxn list of numbers, with the expected methods getRows, GetColumns, getElement, getSize, a toString
	, and a constructor.  There are additionally methods isSolved, which verifies if the puzzle is in it's original state described 
	in the constructor, and the doFunction method, which permutes the numbers in the grid according to the move input.  It is a 
	specific instance of the Function class, which is the same as described above, except this instance has a couple extra methods
	because it represents the identity, the solved state.
	*/

	Grid(int myRows, int myColumns)
	{
		super(myRows,myColumns);
		Grid = new int[myRows][myColumns];
		columns=myColumns;
		rows=myRows;
		for(int i = 0;i<rows;i++)
		{
			for(int j = 0;j<columns;j++)
				Grid[i][j]=i*columns+j;
		}

		// this initializes the grid to the "solved" state, where the first row top left begins with a 1, and then a 2, then 3, so on.
		
	}
	public void makeSolved()
	{
		for(int i = 0;i<rows;i++)
		{
			for(int j = 0;j<columns;j++)
				Grid[i][j]=i*columns+j;
		}
	}
	public int getRows()
	{
		return rows;
	}
	
	public int getColumns()
	{
		return columns;
	}
	public int getElement(int i, int j)
	{
		return Grid[i][j];
	}
	public int getSize() {
		return columns*rows;
	}
	public boolean isSolved()
	{
		for(int i = 0;i<rows;i++)
		{
			for(int j = 0;j<columns;j++)
			{
				if(Grid[i][j]!=columns*i+j)
				return false;
			}
		}
		return true;
	}
	public void doFunction(int[][] function)
	{
		/*the function is essentially another grid that determines the location of each piece after the move has been performed.
		 So if function(0)=1, then the piece at spot zero after the move is performed will be at spot 1.  A lot of things can go
		 wrong in the input, which is why exceptions are very important here.  
		
		 */
		int[][] backupGrid = new int[rows][columns];
		for(int i = 0;i<rows;i++)
		{
			for(int j = 0;j<columns;j++)
			{
				backupGrid[i][j]=Grid[i][j];
			}
		}
		for(int i = 0;i<rows;i++)
		{
			for(int j = 0;j<columns;j++)
			{
				Grid[(int)(function[i][j]/columns)][function[i][j]%columns]=backupGrid[i][j];
				/* This previous line may seem confusing.  It is the line that performs the "move", piece by piece.
				 function[i][j] tells you where a piece goes iteratively, starting with where the piece in the top left is.  
				 The /columns, %columns operations allow this to be translated into where it actually is on the grid.  Lastly, 
				 backupGrid[i][j] is the piece that was in the spot we are moving from.  It is very difficult to explain.
				 */
			}
		}
		
}
	
	public String toString()
	{
		String Return = "";
		for(int i = 0;i<rows;i++)
		{
			for(int j = 0;j<columns;j++)
			{
				if(Grid[i][j]<10)
				{
					Return+=" "+Grid[i][j]+" ";
				}
				else {
					Return+=Grid[i][j]+" ";
				}
			}
			Return+="\n";
		}
		return Return;
	}
	
}
