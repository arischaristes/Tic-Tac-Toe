import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
	Board board = new Board(); // creates a board object
	
	Scanner sc = new Scanner(System.in); // creates a scanner object to get user input
	
	System.out.println("************");
	System.out.println("Tic-Tac-Toe!");
	System.out.println("************");
	System.out.println();
	System.out.println("Please enter the column (A, B or C) and then the row (1, 2, or 3) of your move.");
	
	while(true)
	{
	
		String str = sc.nextLine(); // get input from user
		
		System.out.println("Player move (X) :" + str);
	
		while(!board.checkStringFormat(str)) // check if the input is the desired one
		{
			System.out.println("Invalid Input: Please enter the column and row of your move (Example: A1).");
			str = sc.nextLine(); //reads again input 
		}
	
		int testifempty = board.playerMove(str);
	
		while( testifempty == 1) // check if selected cell is empty
		{
			str = sc.nextLine();
			System.out.println("Player move (X) :" + str);
			testifempty = board.playerMove(str);
		}
	
		board.printBoard(); // print current board state
		int checkstate = board.isWinner();
	
		if(checkstate == 1) // check if there is a winner 
		{
			System.out.println("Player wins");
			break;
		}
		else if(checkstate == 2)
		{
			System.out.println("PC wins");
			break;
		}
		else if(checkstate == 0)
		{
			System.out.println("DRAW");
			break;
		}
		
		String pc = board.computerMove();
		
		System.out.println("Computer Move (O) :" +pc );
		
		board.printBoard();
		
		checkstate = board.isWinner();
		
		if(checkstate == 1) // check if there is a winner 
		{
			System.out.println("Player wins");
			break;
		}
		else if(checkstate == 2)
		{
			System.out.println("PC wins");
			break;
		}
		else if(checkstate == 0)
		{
			System.out.println("DRAW");
			break;
		}
		
	
	}
	
	}

}
