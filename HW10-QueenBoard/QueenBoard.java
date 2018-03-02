// Maggie Zhao
// APCS2 pd01
// HW10 -- [Freddie Mercury, Brian May, Roger Taylor, John Deacon] x n
// 2018-02-27

/***
 * class QueenBoard
 * Generates solutions for N-Queens problem.
 */

public class QueenBoard
{
  private int[][] _board;

  public QueenBoard( int size )
  {
    _board = new int[size][size];
  }


  /***
   * precondition: board is filled with 0's only.
   * postcondition:
   * If a solution is found, board shows position of N queens,
   * returns true.
   * If no solution, board is filled with 0's,
   * returns false.
   */
  public boolean solve()
  {
    // Start at 0,0 (the topleftmost corner), which will call itself recursively
    return solveH(0);
  }


  /**
   *Helper method for solve.
   */
  private boolean solveH( int col )
  {
    // If you've reached the end of the board, all queens have been placed.
      if (col == _board.length)
        return true;

      for (int row = 0; row < _board.length; row ++) {
        // If you can place a queen, place the queen
        if ( addQueen(row, col) ) {
          // and if the next column has a spot available for a queen
          if (solveH(col + 1))
            // return true
            return true;
          }
        // Otherwise, remove the queen, and try the next available row
        removeQueen(row,col);
      }
      return false;
  }

  public void printSolution()
  {
    /** Print board, a la toString...
        Except:
        all negs and 0's replaced with underscore
        all 1's replaced with 'Q'
    */
    if (solve()) {
      String ans = "";
      for (int row = 0 ; row < _board.length; row ++ )  {
        for (int col = 0; col < _board[row].length; col ++) {
          if ( _board[row][col] == 1 )
              ans += "Q\t";
          else
              ans +=  "_\t";
        }
        ans += "\n";
      }
      System.out.println(ans);
    }
    else
      System.out.println("No solution.");
  }



  //================= YE OLDE SEPARATOR =================

  /***
   * Adds a queen at the designated location, and marks all spaces to the right,
      and all squares going diagonally to the upper right and lower right as
      "attackable"- no other queens can be placed there.
   * precondition: The spot at [row][column] of the board should be equal to 0.
   * postcondition: The spot at [row][column] is given a value of 1, and all
      squares to the right of that spot, in the same row, all squares going
      diagonally to the upper right and lower right have a -1 added to its value.
   */
  private boolean addQueen(int row, int col){
    if(_board[row][col] != 0){
	    return false;
    }
    _board[row][col] = 1;
    int offset = 1;
    while(col+offset < _board[row].length){
	    _board[row][col+offset]--;
	    if(row - offset >= 0){
        _board[row-offset][col+offset]--;
	    }
	    if(row + offset < _board.length){
        _board[row+offset][col+offset]--;
	    }
	    offset++;
    }
    return true;
  }


  /***
   * Removes the queen at the designated location, and marks all spaces to the right,
      and all squares going diagonally to the upper right and lower right as
      as clear of that particular queen. Essentially backtracks
   * precondition: The spot at [row][column] of the board has a queen (has a
      value of 1).
   * postcondition: The spot at [row][column] is reverted to its original value
      of 0, and all squares to the right of that spot, in the same row, all
      squares going diagonally to the upper right and lower right have a 1
      added to its value.
   */
  private boolean removeQueen(int row, int col){
    if ( _board[row][col] != 1 ) {
	    return false;
    }
    _board[row][col] = 0;
    int offset = 1;

    while( col+offset < _board[row].length ) {
	    _board[row][col+offset]++;
	    if( row - offset >= 0 ) {
        _board[row-offset][col+offset]++;
	    }
	    if( row + offset < _board.length ) {
        _board[row+offset][col+offset]++;
	    }
	    offset++;
    }
    return true;
  }


  /***
   * Produces a String version of the array.
   * precondition: There is a board to "stringify", that is at least 1x1.
   * postcondition: A String output with N rows and columns, with the appropriate
      array element transcribed in each cell.
   */
  public String toString()
  {
    String ans = "";
    for( int r = 0; r < _board.length; r++ ) {
	    for( int c = 0; c < _board[0].length; c++ ) {
        ans += _board[r][c]+"\t";
	    }
	    ans += "\n";
    }
    return ans;
  }


  //main method for testing...
  public static void main( String[] args )
  {
    QueenBoard b = new QueenBoard(10);
    /**
    System.out.println(b);
    b.addQueen(3,0);
    b.addQueen(0,1);
    System.out.println(b);
    b.removeQueen(3,0);
    System.out.println(b);
    **/
    b.printSolution();
  }

}//end class
