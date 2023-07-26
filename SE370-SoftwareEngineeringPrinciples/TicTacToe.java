import java.util.Scanner;

public class Main {

	private final int BOARDSIZE = 3;
	private char board[][];
  private boolean gameOver, firstPlayer;

  Scanner in = new Scanner(System.in);

  public Main() {
    board = new char[BOARDSIZE][BOARDSIZE];
    firstPlayer = true;
    gameOver = false;
  }
  
  
	public void play()
	{
    int row = 0, column = 0;

    while (!gameOver) {

      // first player’s turn
      if (firstPlayer) {
        
        System.out.print("Player X: Enter row ( 0, 1 or 2 ): ");
        row = in.nextInt();

        System.out.print("Player X: Enter col ( 0, 1 or 2 ): ");
        column = in.nextInt();


        // validate move
        while (!validMove(row, column)) {
          System.out.print("Player X: Enter row ( 0, 1 or 2 ): ");
          row = in.nextInt();

          System.out.print("Player X: Enter col ( 0, 1 or 2 ): ");
          column = in.nextInt();
        }

        firstPlayer = false;
        board[row][column] = 'X';
        printBoard();

        printStatus(1);

      } // end first player’s turn

      // second player’s turn
      else {
        System.out.print("Player O: Enter row ( 0, 1 or 2 ): ");
        row = in.nextInt();

        System.out.print("Player O: Enter col ( 0, 1 or 2 ): ");
        column = in.nextInt();

        // validate move
        while (!validMove(row, column)) {
          System.out.print("Player O: Enter row ( 0, 1 or 2 ): ");
          row = in.nextInt();

          System.out.print("Player O: Enter col ( 0, 1 or 2 ): ");
          column = in.nextInt();
        }

        firstPlayer = true;
        board[row][column] = 'O';
        printBoard();

        printStatus(2);

      }

    }

  }


  public enum Status {

    WIN, DRAW, CONTINUE

  }

  Status status;

  public Main(Status status) {
    this.status = status;
  }

  
	public void printStatus(int player)
  {
    int status = gameStatus();

    // check game status
    switch (status) {

      case 1:
        System.out.println( "Player " + player + " wins.");
        gameOver = true;
        break;

      case 2:
        System.out.println("Game is a draw.");
        gameOver = true;
        break;

      case 3:
        if (player == 1)
          System.out.println("Player O's turn.");
        else
          System.out.println("Player X's turn.");
        break;

    }

  }

	public int gameStatus()
  {
    int a;

    // check for a win on diagonals
    if (board[0][0] != 0 && board[0][0] == board[1][1] && board[0][0] == board[2][2])
      return 1;
    else if (board[2][0] != 0 && board[2][0] == board[1][1] && board[2][0] == board[0][2])
      return 1;

    // check for win in rows
    for (a = 0; a < 3; ++a)
      if (board[a][0] != 0 && board[a][0] == board[a][1] && board[a][0] == board[a][2])
        return 1;

    // check for win in columns
    for (a = 0; a < 3; ++a)
      if (board[0][a] != 0 && board[0][a] == board[1][a] && board[0][a] == board[2][a])
        return 1;

    // check for a completed game
    for (int r = 0; r < 3; ++r)
      for (int c = 0; c < 3; ++c)
        if (board[r][c] == 0)
          return 3; // game is not finished

    return 2; // game is a draw

  }

	public void printBoard()
	{
		System.out.println("----------");
		for(int i = 0; i < 3; i++)
		{
      System.out.print("| ");
		  for(int j = 0; j < 3; j++)
		  {
		    System.out.print(board[i][j] + " | ");
		        
		  }
      System.out.println();
		  System.out.println("----------");
		  
		}
		
	}

	public void printSymbol(int column, char value) {
  
    String output = "";

    if (column != 2) { // first two columns

      switch (value) {
        case 0:
          output = "| ";
          break;
        case 1:
          output = "| 1 ";
          break;
        case 2:
          output = "| 2 ";
          break;
      }
    }
    else { // last column

      switch (value) {
        case 0:
          output = "| |\n";
          break;
        case 1:
          output = "| 1 |\n";
          break;
        case 2:
          output = "| 2 |\n";
          break;
      }
    }

    System.out.print(output);

  }

	public boolean validMove(int row, int column)
	{
		//move has to be in bounds
    return row >= 0 && row < 3 && column >= 0 && column < 3 && board[row][column] == 0;    
	}
	
	public static void main(String[] args)
	{
    
    Main game = new Main();
    game.printBoard();
    System.out.println("Player X's turn. ");
    game.play();
    System.exit(0);

	}
	
}
