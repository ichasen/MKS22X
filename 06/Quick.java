import java.util.ArrayList;
import java.util.Random;
public class Quick{
    public int partition(int[] data, int start, int end){
	Random r = new Random();
	int pivot = data[r.nextInt(data.length)];
	int x = data[start];
	data[start] = data[pivot];
	data[pivot] = x;
	int small = start+1;
	int large = end;
	while (small < large){
	    if (data[small] > pivot){
		int m = data[small];
		int n = data[large];
		data[small] = n;
		data[large] = m;
		large = large - 1;
	    }
	    else{
		small++;
	    }
	}
	int p = data[pivot];
	data[pivot] = data[start];
	data[start] = p;
	return large;
    }
    public static int quickselect(int[] data, int k){
	Quick q = new Quick();
	int x = q.partition(data,0,data.length);
	int[] data2 = new int[q.partition(data,0,data.length-1)];
	int[] data3 = new int[q.partition(data,k,data.length-1)];
	if (x > k){
	    for (int i = 0;i<data2.length;i++){
		data2[i] = data[i];
	    }
	    return quickselect(data2,k);
	}
	else if (x < k){
	    for (int j = 0;j<data3.length;j++){
		data3[j] = data[j];
	    }
	    return quickselect(data3,0);
	}
	else{
	    return data[q.partition(data,0,data.length-1)];
	}
    }
}
