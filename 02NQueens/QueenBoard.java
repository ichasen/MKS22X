public class QueenBoard{
    private int[][] board;
    public QueenBoard(int size){
	for (int i = 0;i<board.length;i++){
	    for (int j = 0;j<board.length;j++){
		board[i][j] = 0;
	    }
	}
    }
    private boolean addQueen(int r,int c){
        if (board[r][c] == 0){
	    board[r][c] = -1;
	    return true;
	}
	int x = r + 1;
	int y = r - 1;
	for (int i = c + 1;i<board.length;i++){
	    board[x][i] += 1;
	    if (y >= 0){
		board [y][i] -= 1;
	    }
	    x++;
	}
	return false;
    }
    private boolean removeQueen(int r,int c){
	if (board[r][c] == 0){
	    return false;
	}
	board[r][c] = 0;
	return true;
    }
    public String toString(){
	String result = "";
	for (int i = 0;i<board.length;i++){
	    for (int j = 0;j<board.length;j++){
		if (board[i][j] == -1){
		    result += " Q";
		}else{
		    result += " _";
		}
	    }
	    result += "/n";
	}
	return result;
    }
    public boolean solve(){
	return solveH(0);
    }
    public boolean solveH(int current){
	if (current >= board.length){
	    return true;
	}
	for (int i = 0;i<board.length;i++){
	    if (addQueen(i,current)){
		if (solveH(current + 1)){
		    return true;
		}
		removeQueen (i,current);
	    }
	}
	return false;
    }
    public int countSolutions(){
	return countH (1,0);
    }
    public int countH(int ans,int current){
	if (current >= board.length){
	    return ans;
	}
	return (ans + current) * ans;
    }
}
