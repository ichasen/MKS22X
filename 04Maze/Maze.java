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

        //erase terminal, go to top left of screen.

        System.out.println("\033[2J\033[1;1H");

    }



    
    public int solve(){
	return solve (0,0);
    }
    private int solve(int row, int col){
        if(animate){

            clearTerminal();
            System.out.println(this);

            wait(20);
        }
        

        return -1; 
    }


}
