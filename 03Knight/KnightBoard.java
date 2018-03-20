public class KnightBoard{
    private int[][] board;
    private int[][] possibleMoves = {{2,1},{2,-1},{1, 2},{1, -2},{-1, 2},{-1, -2},{-2, 1},{-2,  -1}};
    public KnightBoard(int startingRows, int startingCols){
	board = new int [startingRows][startingCols];
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
		if (j == board.length - 1){
		    result += "" + board[i][j] + "\n";
		}else{
		    result += "" + board[i][j] + " ";
		}
	    }
	}
	return result;
    }
    public boolean solve(int startingRow,int startingCols){
	return solveH(0,0,1);
    }
    public boolean solveH(int row,int col,int level){
	if (level > (board.length * board[0].length)){
	    return true;
	}
	if ((row >= 0) && (col >= 0) && (row < board.length) && (col < board[0].length)&& (board[row][col] == 0)){
	    board[row][col] = level;
	    if (solveH(row + 1, col + 2, level + 1) || solveH(row + 2 ,col + 1, level + 1) || solveH(row + 1, col - 2, level + 1) || solveH(row - 1, col + 2, level + 1) || solveH(row - 2, col - 1, level + 1) || solveH(row - 1, col - 2, level + 1) || solveH(row + 2, col - 1, level + 1) || solveH(row - 2, col + 1, level + 1)) {
		return true;
	    }
	}
	return false;
    }
    public int countSolutions(int startingRow,int startingCol){
	return countH(startingRow, startingCol, 1);
    }
    public int countH(int startingRow, int startingCol, int level){
	int ans = 0;
	if (board[startingRow][startingCol] == board.length * board[0].length){
	    return 1;
        }
	else{
	    for (int i[]: possibleMoves){
		if (//check if it is 0){
		    //increment by countH of that startingrow and col
		    }
	    }
	    return ans;
	}
    }
}
