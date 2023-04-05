
public class Board {

	private char[][] board;
	
	public Board() // constructor creates a 3x3 array that represents the board
	{
		board = new char[3][3];
	}
	
	public void printBoard() //this method prints the current board state
	{
		System.out.println("   A B C ");
		System.out.println("1 |" + this.board[0][0] + "|" + this.board[0][1] + "|" + this.board[0][2] + "|");
		System.out.println("2 |" + this.board[1][0] + "|" + this.board[1][1] + "|" + this.board[1][2] + "|");
		System.out.println("3 |" + this.board[2][0] + "|" + this.board[2][1] + "|" + this.board[2][2] + "|");
	}
	
	public void updateBoard(int row, int col, char ch) // this method update the state of a cell , given the row , column and a character either 'X' or 'O' 
	{
		this.board[row][col] = ch;
	}
	
	public boolean isEmpty(int row, int col) // this method checks if a specific cell is empty
	{
		if( this.board[row][col] == 'X' || this.board[row][col] == 'O')
			return false;
		else
			return true;
	}
	
	public int isWinner() // this method returns 1 if player won, 2 if PC won, 0 if there is a draw , and -1 if the game isn't over
	{
		int countX = 0, countO = 0, row, col, draw = 0;
		
		for(row = 0; row < 3; row++) // this loop checks for 3 continuous 'X' or 'O' horizontally 
		{
			for(col = 0; col <3; col++)
			{
				if (this.board[row][col] == 'X')
					countX++;
				else if(this.board[row][col] == 'O')
					countO++;
			}
			if (countX == 3)
				return 1;
			else if(countO == 3)
				return 2;
			
		countX = 0;
		countO = 0;
		}
		
		countX = 0;
		countO = 0;
		
		for(col = 0; col < 3; col++) // this loop checks for 3 continuous 'X' or 'O' vertically
		{
			for(row = 0; row <3; row++)
			{
				if (this.board[row][col] == 'X')
					countX++;
				else if(this.board[row][col] == 'O')
					countO++;
			}
			if (countX == 3)
				return 1;
			else if(countO == 3)
				return 2;
			
		countX = 0;
		countO = 0;
		}
		
		if ((this.board[0][0] == 'X' && this.board[1][1] == 'X' && this.board[2][2] == 'X' ) || (this.board[0][2] == 'X' && this.board[1][1] == 'X' && this.board[2][0] == 'X' )) // check if there is a winner in the main diagonal
			return 1;
		else if ((this.board[0][0] == 'O' && this.board[1][1] == 'O' && this.board[2][2] == 'O' ) || (this.board[0][2] == 'O' && this.board[1][1] == 'O' && this.board[2][0] == 'O' )) // check if there is a winner in the 2nd diagonal
			return 2;
		
		for(row = 0; row <3; row++) // this loop checks if all cells are taken therefore there is a draw. If any empty cell is found it means the game isn't over
			{
				for(col = 0; col<3; col++)
					{
						if(this.board[row][col] == 'X' || this.board[row][col] == 'O')
							draw++;
						else 
							return -1;
					}
			}
		
		if (draw == 9)
			return 0;

		return 3;
		
	}
	
	public String computerMove() // this method handles the move of the Computer using Math.random
	{
		int row = (int)(Math.random()*3);
		int col = (int)(Math.random()*3);
		
		while(!isEmpty(row,col)) // loop uses different random row and cell till an empty one is found
		{
			row = (int)(Math.random()*3);
			col = (int)(Math.random()*3);
		}
		
		updateBoard(row,col,'O'); // updates the board with computers move
		
		char char1,char2; // the following code converts row and col to char and then combines them to a string 
		if (col == 0)
			char1 = 'A';
		else if(col == 1)
			char1 = 'B';
		else 
			char1 = 'C';
		
		char2 = (char)(row+1 + '0');
		
		String str = "" + char1 + char2;
		return str;
	}
	
	public int playerMove(String str) // this method handles the player move 
	{
		
		char char1 = str.charAt(0); // code for extracting and converting the cell position given by the user to row and column number that the 'X' will be placed
		int row = Character.getNumericValue(str.charAt(1));
		int col;
		
		if (char1 == 'A')
			col = 0;
		else if (char1 == 'B')
			col = 1;
		else
			col = 2;
		
		if(!isEmpty(row-1,col)) // checks if the given cell is empty
		{
			System.out.println("The space entered is already taken");
			return 1;
		}
			
		
		updateBoard(row-1,col,'X'); // updates the board with players move
		
		return 0;
	}
	
	public boolean checkStringFormat(String str) // method that checks if the input given by the user is on the desired format 
	{
		if(str.equals("A1") || str.equals("A2") || str.equals("A3") || str.equals("B1") || str.equals("B2") || str.equals("B3") || str.equals("C1") || str.equals("C2") || str.equals("C3"))
			return true;
		else
			return false;
	}
	
}
