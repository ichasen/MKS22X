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
	return countH (0,0);
    }
    public int countH(int ans,int c){
	if (c >= board.length){
	    ans++;
	}
	else{
	    for (int i = 0; i < board.length; i++){
		for (int j = 0;j<board[0].length;j++){
		    if (board[i][j] == 0){
			addQueen(i,j);
			countH(ans,c + 1);
			removeQueen(i,j);
		    }
		}
	    }
	}
	return ans;
    }
    public static void main(String[] args){
    QueenBoard b = new QueenBoard(4);

    System.out.println(b.solve()); //prints true
    System.out.println(b); //prints a valid solution

    try{
      b.solve();
    }catch(IllegalStateException e){
      System.out.println("Error: The board contains non-zero values");
    } //prints "Error: The board contains non-zero values"

    try{
      b.countSolutions();
    }catch(IllegalStateException e){
      System.out.println("Error: The board contains non-zero values");
    } //prints "Error: The board contains non-zero values"

    for (int i = 0; i < 12; i++){
      QueenBoard a = new QueenBoard(i);
      System.out.println("# of Solutions for " + i + ": " + a.countSolutions());
      /*          Expected Values
       i --> # of Solutions   i --> # of Solutions
      0 --> 1                      6 --> 4
      1 --> 1                      7 --> 40
      2 --> 0                      8 --> 92
      3 --> 0                      9 --> 352
      4 --> 2                    10 --> 724
      5 --> 10                  11 --> 2680
      */
      System.out.println(a); //prints out an empty i by i grid of underscores
}
    }
}
