import java.util.ArrayList;
import java.util.Random;
public class Quick{
    public static int partition(int[] data, int start, int end){
	Random r = new Random();
	int pivot = data[r.nextInt(data.length)];
	int x = data[start];
	data[start] = data[pivot];
	data[pivot] = x;
	int small = start+1;
	int i = small + 1;
	int large = end;
	while (i < large){
	    if (data[i] > pivot){
		int m = data[i];
		int n = data[large];
		data[i] = n;
		data[large] = m;
		large = large - 1;
	    }
	    else if (data[i] == pivot){
		i++;
	    }
	    else{
		int a = data[small];
		int b = data[i];
		data[small] = b;
		data[i] = a;
		small++;
		i++;
	    }
`	}
	if(data.length == 1){
	    return large;
	}
	else{
	    partition(data,start,small-1);
	    partition(data,i,end);
	}
	return 0;
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
    public static void quickSort(int[] data){
	Quick q = new Quick();
	if((q.partition(data,0,data.length)) != 1){
	    partition(data,start,small-1);
	    partition(data,i,end);
	}
    }
}
