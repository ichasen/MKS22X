import java.util.Arrays;
public class Merge{
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
    public static void mergesort(int[] data){
	msort(data,new int[data.length],0,data.length-1);
    }
    public static void msort(int[] data, int[] temp, int lo, int hi){
	if (hi-lo <= 2){
	    insertionSort(data);
	    return;
	}
	for (int i = lo;i<=hi;i++){
	    temp[i] = data[i];
	}
	int mid = (lo + hi)/2;
	msort(temp,data,lo,mid);
	msort(temp,data,mid+1,hi);
	merge(data,temp,lo,mid,hi);	
    }
    public static void merge(int[]data, int[]temp, int lo, int mid, int hi){
        int small = lo;
        int middleUp = mid + 1;
        int current = lo;
        while (small <= mid && middleUp <= hi){
            if (temp[small] < temp[middleUp]){
                data[current] = temp[small];
                small++;
            }
            else{
                data[current] = temp[middleUp];
                middleUp++;
            }
            current++;
        }
        if (small <= mid){
            for(int i = small; i <= mid; i++){
                data[current] = temp[i];
                current++;
            }
        }
        else{
            for (int i = middleUp;i <= hi ;i++){
                data[current] = temp[i];
                current++;
            }
        }
    }
}
