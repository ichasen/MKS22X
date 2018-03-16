import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;
import java.lang.Math;
public class Quick{
    public static int partition(int[] data, int start, int end){
	Random r = new Random();
	int pivot = data[r.nextInt(data.length)];
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
	if(data.length == 0){
	    return;
	}
	if(start < end){
	    int pivot = partition(data,start,end);
	    quickH(data,start,pivot-1);	
	    quickH(data,pivot+1,end);
	}
    }
}
