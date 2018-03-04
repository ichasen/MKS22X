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
	return solveH (0,0);
    }
    private int solveH(int row, int col){
        if(animate){
	    clearTerminal();
            System.out.println(this);
	    wait(20);
        }
	int ans = 0;
	char r = maze[row][col+1];
	char l = maze[row][col - 1];
	char u = maze[row - 1][col];
	char d = maze[row + 1][col];
	if (r == 'E' || l == 'E' || u == 'E' || d == 'E') {
	    return ans;
	}
	if (r == ' ') {
	    ans += 1;
	    return solveH(row,col+1);
	}
	if (d == ' ') {
	    ans += 1;
	    return solveH(row+1,col);
	}
	if (l == ' ') {
	    ans += 1;
	    return solveH(row,col-1);
	}
	if (u == ' ') {
	    ans += 1;
	    return solveH(row-1,col);
	}
        return -1; 
    }
    public static void main(String[]args){
        Maze f;
        f = new Maze("data1.dat");//true animates the maze.
        
        f.setAnimate(true);
        f.solve();

        System.out.println(f);
    }

}
