import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
import java.io.File;
public class USACO{
    public static int bronze(String filename){
	int height;
	int rowStomp;
	int colStomp;
	int amountStomp;
	File f = new File(filename);
	Scanner s = new Scanner(f);
	int r = Integer.parseInt(s.next());
	int c = Integer.parseInt(s.next());
	return bronzeH(rowStomp,colStomp,height,amountStomp);
    }
    public static int bronzeH(int r,int c, int h, int a){
	int[][] lake;
	lake = new int [r][c];
	int depth = 0;
	int left = lake[r][c-1];
	int right = lake[r][c+1];
	int above = lake[r-1][c];
	int below = lake[r+1][c];
	if (left == lake[r][c]){
	    lake[r][c-1] -= a;
	}
	if (right == lake[r][c]){
	    lake[r][c+1] -= a;
	}
	if (above == lake[r][c]){
	    lake[r-1][c] -= a;
	}
	if (below == lake[r][c]){
	    lake[r+1][c] -= a;
	}
	for (int i = 0;i<lake.length;i++){
	    for (int j = 0;j<lake[0].length;j++){
		lake[i][j] -= h;
		depth += lake[i][j];
	    }
	}
	return depth * 72 * 72;
    }
}
