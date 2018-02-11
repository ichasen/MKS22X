public class QueenBoard{
    private int[] board;
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
	return false;
    }
    private boolean removeQueen(int r,int c){
	if (board[r][c] == 0){
	    return false;
	}else{
	    board[r][c] = 0;
	    return true;
	}
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
    }
    public boolean solve(){
	return solveH(0);
    }
    public boolean solveH(int current){
	for (int i = 0;i<board.length;i++){
	    for (int j = 0;j<board.length;j++){
		if (board[i][j] != 0){
		    throw new IllegalStateException("Board must not start with any nonzero value");
		}
	    }
	}
	for (int x = 0;x<board.length;x++){
	    for (int y = 0;y<board.length;y++){
		if (addQueen(x,y)){
		    board[x][y] = -1;
		}
	    }
	}
    }
    public int countSolutions(){
	return countH(0);
    }
    public int countH(int sum){

    }
    public void main(String[] args){

    }
}
