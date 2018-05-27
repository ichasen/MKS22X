import java.util.ArrayList;
import java.util.*;
import java.io.*;
public class USACO{
    public static int bronze(String filename) throws FileNotFoundException{
	File f = new File(filename);
	Scanner s = new Scanner(f);
       	String word = s.nextLine();
	String[] text = word.split(" ");
	int r = Integer.parseInt(text[0]);
	int c = Integer.parseInt(text[1]);
	int height = Integer.parseInt(text[2]);
	int amount = Integer.parseInt(text[3]);
	int x = 0;
	int y = 0;
	int[][] lake = new int[r][c];
	for(int i = 0;i < r;i++){
	    String element = s.nextLine();
	    String[] elements = element.split(" ");
	    for(int j = 0; j < c; j++){
		lake[i][j] = Integer.parseInt(elements[j]);
	    }
	}
	for(int i = amount;i > 0;i--){
	    String instruction = s.nextLine();
	    String[] instructions = instruction.split(" ");
	    int r_ = Integer.parseInt(instructions[0]) - 1;
	    int c_ = Integer.parseInt(instructions[1]) - 1;
	    int quantity = Integer.parseInt(instructions[2]);
	    int max = 0;
	    for(int a = r_; a < r_ + 3;a++){
		for(int b = c_ ;b < c_ + 3;b++){
		    if(lake[a][b] > max){
			max = lake[a][b];		    
		    }
		}
	    }
	    for(int in = r_;in < r_ + 3; in++){
		for(int j = c_; j < c_ + 3;j++){
		    if(lake[in][j] == max){
			x = max - quantity;
			lake[in][j] = x;
		    }
		    if(lake[in][j] + quantity > max){			
			y = max - quantity;
			lake[in][j] = y;
		    }
		}
	    }
	}
	int depth = 0;
	for(int i = 0; i < lake.length; i++){
	    for(int j = 0; j < lake[i].length; j++){		
		int current = height - lake[i][j];
		if(current > 0){
		    depth += current;
		}		
	    }
	}
	return depth * 72 * 72;
    }
    public static int silver(String filename) throws FileNotFoundException{	
	File f = new File(filename);
	Scanner s = new Scanner(f);	
	int r = s.nextInt();
	int c = s.nextInt();
	int t = s.nextInt();		
	s.nextLine();		
	char[][] map = new char[r][c];	
	for (int x = 0; x < r; x++) {
	    String row = s.nextLine();
	    for (int y = 0; y < c; y++){
		map[x][y] = row.charAt(y);
	    }
	}	
	int row1 = s.nextInt();
	int col1 = s.nextInt();
	int row2 = s.nextInt();
	int col2 = s.nextInt();	
	int[][] all = new int[r][c];
	all[row1 - 1][col1 - 1] = 1;		
	int current = 0;
	while (current < t){
	    int[][] mapUnused = new int[r][c];
	    for (int x = 0; x < r; x++){
		for (int y = 0; y < c; y++){
		    if (map[x][y] != '*'){
			if ((x+1) < r){
			    mapUnused[x][y] = mapUnused[x][y] + all[x+1][y];
			}
			if ((x-1) >= 0){
			    mapUnused[x][y] = mapUnused[x][y] + all[x-1][y];
			}
			if ((y+1) < c){
			    mapUnused[x][y] = mapUnused[x][y] + all[x][y+1];
			}
			if ((y-1) >= 0){
			    mapUnused[x][y] = mapUnused[x][y] + all[x][y-1];
			}
		    }
		}
	    }
	    for (int x = 0; x < r; x++){
		for (int y = 0; y < c; y++){
		    all[x][y] = mapUnused[x][y];
		}
	    }
		
	    current++;
	}
	int ans = all[row2-1][col2-1];
	return ans;
    }
}
