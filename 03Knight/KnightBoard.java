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
		if (startingRow < 0 || startingCols < 0){
		    throw new IllegalArgumentException();
		}
	    }
	}
	return solveH(0,0,1);
    }
    public boolean solveH(int row,int col,int level){
	if (board.length < 2 || board[0].length < 2){
	    return false;
	}
	if (row >= board.length || col >= board[0].length){
	    return false;
	}
	else{
	    for (int i = 0;i<board.length;i++){
		for (int j = 0;j<board[0].length;j++){
		    if ((board[i][j] == 0) && ((row + 2 == i && col + 1 == j) || (row + 1 == i && col + 2 == j) || (row + 2 == i && col - 1 == j) || (row - 2 == i && col + 1 == j) || (row - 1 == i && col + 2 == j) || (row + 1 == i && col - 2 == j) || (row - 2 == i && col - 1 == j) || (row - 1 == i && col - 2 == j))){
			board[i][j] = level;
			solveH(i,j,level+1);
		    }
		    return true;
		}
		if (level == (board.length * board[0].length)){
		    return true;
		}
		return false;
	    }
	}
	return false;
    }
    public static void main (String[] args){
	KnightBoard x = new KnightBoard(1,5);
	if (x.solveH(0,0,0)){
	    System.out.println ("good");
	}
	else{
	    System.out.println ("Nope");
	}
    }
}
