public class QueenBoard{
    private int[][] board;
    public QueenBoard(int size){
	board = new int[size][size];
	for (int i = 0;i<board.length;i++){
	    for (int j = 0;j<board.length;j++){
		board[i][j] = 0;
	    }
	}
    }
    private boolean addQueen(int r,int c){
	if (board [r][c] == 0){
	    board[r][c] = -1;
	    for(int i = c + 1;i < board.length; i++){
		board[r][i] += 1;
	    }
	    for (int i=r+1,j=c+1;i<board.length && j<board.length;i++,j++){
		board[i][j] += 1;
	    }
	    for (int i=r-1,j=c+1;i>=0 && j<board.length;i--,j++){
		board[i][j] += 1;
	    }	    
	    return true;
	}
	return false;
    }
    private boolean removeQueen(int r,int c){
	if (board[r][c] != -1) {
	    return false;
	}
	else{
	    board[r][c]++;
	    for (int i=1; c+i<board.length;i++){
		board[r][c+i] -= 1;
		if (r+i < board.length){
		    board[r+i][c+i] -= 1;
		}
		if (r-i >= 0){
		    board[r-i][c+i] -= 1;
		}
	    }
	    return true;
	}
    }
    public String toString(){
	String result = "";
	for (int i = 0;i<board.length;i++){
	    for (int j = 0;j<board.length;j++){
		if (board[i][j] == -1){
		    result += "Q ";
		}else{
		    result += "_ ";
		}
	    }
	    result += "\n";
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
		else{
		    removeQueen (i,current);
		}
	    }
	}
	return false;
    }
    public int countSolutions(){
	return countH (0);
    }
    public int countH(int c){
	int ans = 0;
	if (c >= board.length){
	    ans++;
	}
	else{
	    for (int i = 0; i < board.length; i++){
		if (addQueen(i,c)){
		    ans += countH(c+1);
		    removeQueen(i,c);
		}
	    }
	}
	return ans;
    }
}
