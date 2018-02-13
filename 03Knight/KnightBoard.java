public class KnightBoard{
    private int[][] board;
    public KnightBoard(int startingRows, int startingCols){
	if (startingRows < 0 || startingCols < 0){
	    throw new IllegalArgumentException();
	}
	board = new int [startingRows][startingCols];
	for (int i = 0;i<board.length;i++){
	    for (int j = 0;j<board[0].length;j++){
		board [i][j] = 0;
	    }
	}
    }
    public String toString(){
	String result = "";
	for (int i = 0;i<board.length;i++){
	    for (int j = 0;j<board[0].length;j++){
	        result += "" + board[i][j] + " ";
	    }
	}
	return result;
    }
    public boolean solve(int startingRow,int startingCols){
        for (int i = 0;i<board.length;i++){
	    for (int j = 0;j<board[0].length;j++){
		if (board[i][j] != 0){
		    throw new IllegalStateException();
		}
		if (board[i][j] < 0){
		    throw new IllegalArgumentException();
		}
	    }
	}
	return solveH(0,0,0);
    }
    public boolean solveH(int row,int col,int level){

    }
}
