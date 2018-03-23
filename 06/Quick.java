import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;
import java.lang.Math;
public class Quick{
    public static int partition(int[] data, int start, int end){
	Random r = new Random();
	int pivotDigit = r.nextInt(end-start) + start;
	int pivot = data[pivotDigit];
	int i = start+1;
	int small = start;
	int large = end-1;
	while(i <= large){
	    if (data[i] == pivot){
		i++;
	    }
	    else if (data[i] > pivot){
		swap(data,i,large);
		large--;
	    }else{
		swap(data,small,i);
		small++;
		i++;
	    }
	}
	return large;
    }

    private static void swap(int[] data, int a, int b){
	int x = data[a];
	data[a] = data[b];
	data[b] = x;
    }
    public static int quickselect(int[] data, int k){
	int small = 0;
	int large = data.length - 1;
	while(small<large){
	    int pivot = partition(data,small,large);
	    if(pivot < k){
		small = pivot + 1;
	    }
	    else if(pivot > k){
		large = pivot - 1 ;
	    }
	    else{
		return data[pivot];
	    }
	}	    
	return data[small];
    }

    public static void quicksort(int[] data){
	quickH(data,0,data.length - 1);
    }

    public static void quickH(int[] data,int start,int end){
	if(data.length == 1){
	    return;
	}
	if(start < end){
	    int pivot = partition(data,start,end);
	    quickH(data,start,pivot);	
	    quickH(data,pivot+1,end);
	}	
    }
    private static final int INCREASE = 0;
    private static final int DECREASE = 1;
    private static final int STANDARD = 2;
    private static final int SMALL_RANGE = 3;
    private static final int EMPTY = 4;

    private static String name(int i){
	if(i==0)return "Increassing";
	if(i==1)return "Decreassing";
	if(i==2)return "Normal Random";
	if(i==3)return "Random with Few Values";
	if(i==4)return "size 0 array";
	return "Error stat array";

    }

    private static int create(int min, int max){
	return min + (int)(Math.random()*(max-min));
    }

    private static int[]makeArray(int size,int type){
	int[]ans =new int[size];
	if(type == STANDARD){
	    for(int i = 0; i < size; i++){
		ans[i]= create(-1000000,1000000);
	    }
	}
	if(type == INCREASE){
	    int current = -5 * size;
	    for(int i = 0; i < size; i++){
		ans[i]= create(current,current + 10);
		current += 10;
	    }
	}
	if(type == DECREASE){
	    int current = 5 * size;
	    for(int i = 0; i < size; i++){
		ans[i]= create(current,current + 10);
		current -= 10;
	    }
	}
	if(type == SMALL_RANGE){
	    for(int i = 0; i < size; i++){
		ans[i]= create(-5,5);
	    }
	}
	if(type == EMPTY){
	    ans = new int[0];
	}
	return ans;
    }

    public static void main(String[]args){
	if(args.length < 2)return;
    
	int size =  Integer.parseInt(args[0]);
	int type =   Integer.parseInt(args[1]);

	int [] start = makeArray(size,type);
	int [] result = Arrays.copyOf(start,start.length);
	Arrays.sort(result);
    
	long startTime = System.currentTimeMillis();
	/*
	 * Test your sort here!
	 */
	Quick.quicksort(start);
	long elapsedTime = System.currentTimeMillis() - startTime;
	if(Arrays.equals(start,result)){
	    System.out.println("PASS Case "+name(type)+" array, size:"+size+" "+elapsedTime/1000.0+"sec ");
	}else{
	    System.out.println("FAIL ! ERROR ! "+name(type)+" array, size:"+size+"  ERROR!");
	}
    }
}
