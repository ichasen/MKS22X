import java.util.*;
import java.util.ArrayList;
import java.util.Random;
public class Quick{
    public int partition(int [] data, int start, int end){
	Random r = new Random();
	int pivot = data.get(r.nextInt(data.size()));
	int x = data.get(start);
	data.set(data.indexOf(pivot),x);
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
}
