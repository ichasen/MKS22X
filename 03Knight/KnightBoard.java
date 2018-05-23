import java.io.*;
import java.util.*;
public class KnightBoard{
    private int[][] board;
    private int[][] possibleMoves = {{2,1},{2,-1},{1, 2},{1, -2},{-1, 2},{-1, -2},{-2, 1},{-2,-1}};
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
		if (j == board.length - 1){
		    result += "" + board[i][j] + "\n";
		}else{
		    result += "" + board[i][j] + " ";
		}
	    }
	}
	return result;
    }
    public boolean solve(int startingRow,int startingCol){
	if (startingRow < 0 || startingCol < 0 || startingRow >= board.length || startingCol >= board[0].length){
	    throw new IllegalArgumentException();
	}
	for (int i = 0;i<board.length;i++){
	    for (int j = 0;j<board[0].length;j++){
		if (board[i][j] != 0){
		    throw new IllegalStateException();
		}
	    }
	}
	return solveH(startingRow,startingCol,1);
    }
    public boolean solveH(int row,int col,int level){
	if (level == (board.length * board[0].length)){
	    if (board[row][col] == 0){
		board[row][col] = level;
	    }
	    return true;
	}
	for (int i = 0;i<possibleMoves[0].length;i++){
	    int x = row + possibleMoves[i][0];
            int y = col + possibleMoves[i][1];
	    if (x >= 0 && x < board.length && y >= 0 && y < board.length){
		board[row][col] = level;
		if (solveH(x,y,level+1)){
		    return true;
		}
		board[row][col] = 0;
	    }
        }
	return false;
    }
    public int countSolutions(int startingRow,int startingCol){
	for (int i = 0;i<board.length;i++){
	    for (int j = 0;j<board[0].length;j++){
		if (board[i][j] != 0){
		    throw new IllegalStateException();
		}
	    }
	}
	if (startingRow < 0 || startingCol < 0 || startingRow >= board.length || startingCol >= board[0].length){
	    throw new IllegalArgumentException();
	}
	return countH(startingRow,startingCol,1);
    }
    public int countH(int row,int col,int level){
	int ans = 0;
	if (level == board.length * board[0].length){
	    return 1;
	}
	for (int[] move:possibleMoves){
	    int x = row+move[0];
	    int y = row+move[1];
	    try{
	    if (board[x][y] == 0){
		board[x][y] = level;
		ans += countH(x,y,level+1);
		board[row][col] = 0;
	    }
	    }
	    catch(IndexOutOfBoundsException e){
	    }
	}
	return ans;
    }
    public static void main(String[] args){
	KnightBoard a = new KnightBoard(3,3);

	System.out.println(a);
	/* Prints
	   _ _ _
	   _ _ _
	   _ _ _
	*/

	for (int i = 0; i < 3; i++){
	    for (int j = 0; j < 3; j++){
		if (a.solve(i,j)){
		    System.out.println("There is an error with your solve method");
		}
	    }
	} //prints nothing

	System.out.println(a.countSolutions(0,0)); //prints 0



	KnightBoard b = new KnightBoard(5,5);
	System.out.println(b.solve(0,0)); //prints true
	System.out.println(b); //prints a valid solution

	try{
	    b.solve(0,0);
	}catch(IllegalStateException e){
	    System.out.println("Error: The board contains non-zero values");
	} //prints "Error: The board contains non-zero values"

	try{
	    b.countSolutions(0,0);
	}catch(IllegalStateException e){
	    System.out.println("Error: The board contains non-zero values");
	} //prints "Error: The board contains non-zero values"

	try{
	    KnightBoard b1 = new KnightBoard(-1,0);
	}catch(IllegalArgumentException e){
	    System.out.println("Error: There cannot be negative parameters in the constructor");
	} //prints "Error: There cannot be negative parameters in the constructor"

	try{
	    KnightBoard b1 = new KnightBoard(1,-1);
	}catch(IllegalArgumentException e){
	    System.out.println("Error: There cannot be negative parameters in the constructor");
	} //prints "Error: There cannot be negative parameters in the constructor"

	try{
	    KnightBoard b1 = new KnightBoard(-1,-1);
	}catch(IllegalArgumentException e){
	    System.out.println("Error: There cannot be negative parameters in the constructor");
	} //prints "Error: There cannot be negative parameters in the constructor"

	try{
	    KnightBoard b1 = new KnightBoard(5,5);
	    b1.solve(0,-1);
	}catch(IllegalArgumentException e){
	    System.out.println("Error: There cannot be negative parameters");
	} //prints "Error: There cannot be negative parameters"

	try{
	    KnightBoard b1 = new KnightBoard(5,5);
	    b1.solve(-1,0);
	}catch(IllegalArgumentException e){
	    System.out.println("Error: There cannot be negative parameters");
	} //prints "Error: There cannot be negative parameters"

	try{
	    KnightBoard b1 = new KnightBoard(5,5);
	    b1.solve(-1,-1);
	}catch(IllegalArgumentException e){
	    System.out.println("Error: There cannot be negative parameters");
	} //prints "Error: There cannot be negative parameters"



	for (int i = 0; i < 5; i++){
	    for (int j = 0; j < 5; j++){
		KnightBoard abc = new KnightBoard(5,5);
		System.out.println(abc.solve(i,j)); //prints alternating lines of true/false starting with true
	    }
	}
	KnightBoard c = new KnightBoard(5,5);

	int totalSol = 0;
	for (int i = 0; i < 5; i++){
	    for (int j = 0; j < 5; j++){
		totalSol += c.countSolutions(i,j);
	    }
	}

	System.out.println(totalSol); //prints 1728

	KnightBoard d = new KnightBoard(5,5);
	System.out.println(d.countSolutions(0,0)); //prints 304

    }	
}

