import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;
import java.lang.Math;
public class Quick{
    public static int[] partition(int[] data, int start, int end){
	Random r = new Random();
	int pivotDigit = r.nextInt(end-start) + start;
	int pivot = data[pivotDigit];
	int i = start;
	int small = start;
	int large = end;
	swap(data,pivotDigit,small);
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
	swap(data,small,large);
	int[] ans = new int[2];
	ans[0] = small;
	ans[1] = large;
	return ans;
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
	    int[] partitioned = partition(data,small,large);
	    int pivot = partitioned[1];
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
	if(end - start <= 5){
	    insertionSort(data);
	}
	else{
	    if (start <= end){
		int[] partitioned = partition(data,start,end);
		quickH(data,start,partitioned[0]-1);
		quickH(data,partitioned[1]+1,end);
	    }
	}
    }
    public static void insertionSort(int[] data){
	for (int i = 1; i < data.length; i++){
	    int key = data[i];
	    int j = i-1;
	    while (j >= 0 && data[j] > key){
		data[j+1] = data[j];
		j = j-1;
	    }
	    data[j+1] = key;
	}
    }
    public static void main(String[]args){
	int[] ary = {9,8,7,6,5,4,3,2,1,0,-1,-2,-3,-4,-5};
	System.out.println(Quick.quickselect(ary,5) + " <- Should be 0");
	int[] ary1 = {9,5,8,7,5,6,5,-3,4,5,3,4,5,1,2,3,4,4,3,5,4,3};
	System.out.println(Quick.quickselect(ary1,19) + " <- Should be 7");
	System.out.println(Quick.quickselect(ary1,13) + " <- Should be 5");
	System.out.println(Quick.quickselect(ary1,0) + " <- Should be -3");
	System.out.println(Quick.quickselect(ary1,ary1.length-1) + " <- Should be 9");
	int[] ary2 = {3,6,1,2,4,6,8,99,1,2,32,45,123,-23,12,-30,-12,-3};
	Quick.quicksort(ary2);
	System.out.println("Your sorted array" + "\n" + Arrays.toString(ary2));
	System.out.println("The correct array\n[-30, -23, -12, -3, 1, 1, 2, 2, 3, 4, 6, 6, 8, 12, 32, 45, 99, 123]");
    }
}
