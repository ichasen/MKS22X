import java.util.ArrayList;
import java.util.Random;
public class Quick{
    public int partition(int[] data, int start, int end){
	Random r = new Random();
	int pivot = data[r.nextInt(data.size())];
	int x = data[start];
	data[data.indexOf(pivot),x];
	data.set(start,pivot);
	int small = start+1;
	int large = end;
	while (small < large){
	    if (data[small] > pivot){
		int m = data.get(small);
		int n = data.get(large);
		data.set(small,n);
		data.set(large,m);
		large = large - 1;
	    }
	    else{
		small++;
	    }
	}
	return large;
    }
    public static int quickselect(int[] data, int k){
	int[] data2 = new int[partition(data,0,data.length-1)];
	int[] data3 = new int[partition(data,k,data.length-1)];
	if (partition(data,0,data.length-1) > k){
	    for (int i = 0;i<data2.length;i++){
		data2[i] = data[i];
	    }
	    return quickselect(data2,k);
	}
	else if (partition(data,0,data.length-1) < k){
	    for (int j = 0;j<data3.length;j++){
		data3[j] = data[j];
	    }
	    return quickselect(data3,0);
	}
	else{
	    return data[partition(data,0,data.length-1)];
	}
	return 0;
    }
}
