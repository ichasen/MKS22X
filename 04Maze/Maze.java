import java.util.*;
import java.io.*;
public class Maze{
    private char[][]maze;
    private boolean animate;//false by default
    public Maze(String filename){
	try{
	    File x = new File (filename);
	    Scanner s = new Scanner (x);
	    int y = s.nextLine().length();
	    for (int i = 0;i<y;i++){
		for (int j = 0;j<y;j++){
		    while (s.hasNext()){
			maze[i][j] = s.nextLine().charAt(i);
		    }
		}
	    }
	}
	catch (FileNotFoundException f){
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
        for (int i = 0;i<maze.length;i++){
	    for (int j = 0;j<maze[0].length;j++){
		if (maze[i][j] == 'S'){
		    maze[i][j] = '@';
		}
		if (maze[i][j] == 'E'){
		    return ans;
		}
		if ((maze[i-1][j] == '@' || maze[i-1][j-1] == '@' || maze[i][j-1] == '@' || maze[i+1][j-1] == '@' || maze[i+1][j] == '@' || maze[i+1][j+1] == '@' || maze[i][j+1] == '@' || maze[i-1][j+1] == '@') && maze[i][j] == ' '){
		    maze[i][j] = '@';
		    return solveH(i,j);
	        }
		else{
		    for (int x = 0;i<maze.length;i++){
			for (int y = 0;j<maze[0].length;j++){
			    if (maze[x][y] != '#'){
				maze[x][y] = ' ';
			    }
			    if (maze[x][y] == 'S'){
				return solveH (x,y);
			    }
			}
		    }
		}
	    }
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
