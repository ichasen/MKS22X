import java.util.*;
import java.io.*;
public class Maze{
    private char[][]maze;
    private boolean animate;//false by default
    public Maze(String filename) {
	try{
	    int length = 0;
	    File x = new File (filename);
	    Scanner s = new Scanner (x);
	    String line2;
	    while (s.hasNextLine()){
		line2 = s.nextLine();
		length++;
	    }
	    s = new Scanner (x);
	    String line = s.nextLine();
	    int y = line.length();
	    maze = new char [length][y];
	    int current = 0;
	    for (int i = 0;i<y-1;i++){
		maze[current][i] = line.charAt(i);
	    }
	    current++;
	    while (s.hasNextLine()){
		line = s.nextLine();
		for (int i = 0;i<y-1;i++){
		    maze[current][i] = line.charAt(i);
		}
	    
		current++;
	    }
	}
	catch(FileNotFoundException f){
	    System.out.println("File not found");
	}
    }
    private void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }
    public void setAnimate(boolean b){
	animate = b;
    }
    public void clearTerminal(){
	System.out.println("\033[2J\033[1;1H");
    }
    public int solve(){
        int row = 0;
	int col = 0;
	for (int i = 0;i<maze.length;i++){
	    for (int j = 0;j<maze[i].length;j++){
		if (maze[i][j] == 'S'){
		    row = i;
		    col = j;
		}
	    }
	}
	return solveH(row,col);
    }
    private int solveH(int row, int col){
	int ans = 0;
	int[][] possibleMoves  = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
        if(animate){
	    clearTerminal();
            System.out.println(this);
	    wait(20);
        }
	if (maze[row][col] == 'E'){
	    ans++;
	}
	else{
	    maze[row][col] = '@';
	}
	for (int i = 0;i<possibleMoves.length;i++){
	    if (solveH(row+possibleMoves[i][0],col+possibleMoves[i][1]) > 0){
		return solveH(row+possibleMoves[i][0],col+possibleMoves[i][1]);
	    }
	}
	if (ans > 0){
	    return ans;
	}else{
	    return -1;
	}
    }
    public static void main(String[]args){
        Maze f;
        f = new Maze("data1.dat");//true animates the maze.
        
        f.setAnimate(true);
        f.solve();

        System.out.println(f);
    }

}
