import java.util.*;
import java.io.*;
public class Maze{
    private char[][]maze;
    int[][] possibleMoves  = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
    private boolean animate;//false by default
    public Maze(String filename) throws FileNotFoundException{
	animate = false;
	int x = 0;
	int y = 0;
	File f = new File(filename);
	Scanner s = new Scanner(f);
	int current = 0;
	ArrayList<String> text = new ArrayList<>();
	while (s.hasNextLine()){
	    current++;
	    text.add(s.nextLine());
	}
	Scanner a = new Scanner(f);
	maze = new char[current][text.get(1).length()];
	for (int i = 0; i < text.size(); i++){
	    for (int j = 0; j < text.get(i).length(); j++){
		maze[i][j] = text.get(i).charAt(j);
		if (maze[i][j] == 'E'){
		    x++;
		}
		if (maze[i][j] == 'S'){
		    y++;
		}
	    }
	}
	if (x != 1 || y != 1){
	    throw new IllegalStateException();
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
	for (int i = 0;i<maze.length;i++){
	    for (int j = 0;j<maze[i].length;j++){
		if (maze[i][j] == 'S'){
		    maze[i][j] = '@';
		    return solveH(i,j,0);
		}
	    }
	}
	return -1;
    }
    private int solveH(int row, int col,int level){
        if(animate){
	    clearTerminal();
            System.out.println(this);
	    wait(20);
        }
	if (maze[row][col] == 'E'){
	    return level;
	}
	for (int i = 0;i<possibleMoves.length;i++){
	    maze[row][col] = '@';
	    if(maze[row + possibleMoves[i][0]][col + possibleMoves[i][1]] == ' ' || maze[row + possibleMoves[i][0]][col + possibleMoves[i][1]] == 'E'){
		int nextStep = solveH(row + possibleMoves[i][0],col + possibleMoves[i][1],level + 1);
		if(nextStep != -1){
		    return nextStep;
		}
	    }
	    maze[row][col] = '.';
	}
	return -1;
    }
    public String toString(){
	String ans = "";
	for (int i = 0;i < maze.length;i++){
	    for (int j = 0;j < maze[0].length;j++){
		ans += maze[i][j];
	    }
	    ans += "\n";
	}
	return ans;
    }
    public static void main(String[]args){
        Maze f;
        f = new Maze("data1.dat");//true animates the maze.
        
        f.setAnimate(true);
        f.solve();

        System.out.println(f);
    }

}
