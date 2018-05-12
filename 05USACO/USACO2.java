import java.util.ArrayList;
import java.util.*;
import java.io.*;
public class USACO2{
    public static int bronze(String filename){
	try{
	File f = new File(filename);
	Scanner s = new Scanner(f);
	int r = Integer.parseInt(s.next());
	int c = Integer.parseInt(s.next());
	int height = Integer.parseInt(s.next());
	int amount  = Integer.parseInt(s.next());
	int[][] lake = new int[r][c];
	for (int i = 0;i<r;i++){
	    for (int j = 0;j<c;j++){
		lake[i][j] = Integer.parseInt(s.next());
	    }
	}
	while (amount > 0){	    
	    int rowStomp =  Integer.parseInt(s.next()) - 1;
	    int colStomp =  Integer.parseInt(s.next()) - 1;
	    int maxElement = lake[rowStomp][colStomp];
	    for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (lake[rowStomp+i][colStomp+j] > maxElement) {
                        maxElement = lake[rowStomp+i][colStomp+j];
                    }
                }
            }
            int newElement = maxElement - Integer.parseInt(s.next());
            for (int x = 0; x < 3; x++) {
                for (int y = 0; y < 3; y++) {
                    if (lake[rowStomp+x][colStomp+y] > newElement) {
                        lake[rowStomp][colStomp+y] = newElement;
                    }
                }
            }
            amount--;
	}
	int depth = 0;
	for (int row = 0;row<r;row++){
	    for (int col = 0;col<c;col++){
		if (height > lake[row][col]){
		    lake[row][col] = height - lake[row][col];
		    depth = depth + lake[row][col];
		}
	    }
	}
	return depth * 72 * 72;
	}
	catch (FileNotFoundException f){
	    System.exit(0);
	}
	return -1;
    }
    public static int silver(String filename){
	try{	
	    File f = new File(filename);
	    Scanner s = new Scanner(f);
	    int r = Integer.parseInt(s.next());
	    int c = Integer.parseInt(s.next());
	    int t = Integer.parseInt(s.next());
	    char[][] map = new char[r][c];
	    int current = 0;
	    String row = s.nextLine();
	    for (int i = 0;i<r;i++){
		row = s.nextLine();
		for (int j = 0;j<c;j++){
		    map[i][j] = row.charAt(j);
		}
	    }
	    String[] mapArray = row.split(" ");
	    int row1 = Integer.parseInt(mapArray[0])-1;
	    int col1 = Integer.parseInt(mapArray[1])-1;
	    int row2 = Integer.parseInt(mapArray[2])-1;
	    int col2 = Integer.parseInt(mapArray[3])-1;
	    int[][] mapUnused = new int [r][c];
	    int[][] mapUsed = new int[r][c];
	    for (int x = 0;x<r;x++){
		for (int y = 0;y<c;y++){
		    mapUnused[r][c] = -1;
		}
	    }
	    mapUnused[row1][col1] = 1;
	    while (t>0){
		for (int a = 0;a<r;a++){
		    for (int b = 0;b<c;b++){
			mapUsed[a][b] = mapUnused[a][b];
		    }
		}
		for (int d = 0; d < r; d++){
		    for (int e = 0; e < c; e++){
			if (mapUnused[d][e] != -1){
			    mapUnused[d][e] = 0;
			    if (d + 1 < r && mapUnused[d + 1][e] >= 0){
				mapUnused[d][e] += mapUsed[d + 1][e];
			    }
			    if (d - 1 >= 0 && mapUnused[d - 1][e] >= 0){
				mapUnused[d][e] += mapUsed[d - 1][e];
			    }
			    if (e + 1 < c && mapUnused[d][e+1] >= 0){
				mapUnused[d][e] += mapUsed[d][e + 1];
			    }
			    if (e - 1 >= 0 && mapUnused[d][e-1] >= 0){
				mapUnused[d][e] += mapUsed[d][e-1];
			    }			    
			}
		    }
		}
		t--;
	    }
	    return mapUnused[row2][col2];
	}
	catch(FileNotFoundException e){
	    return -1;
	}
    }
}
