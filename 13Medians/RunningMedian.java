import java.util.*;
import java.io.*;
public class RunningMedian{
    MyHeap maxHeap = new MyHeap<Double>();
    MyHeap minHeap = new MyHeap<Double>(false);
    public void add(Double element){
	if (maxHeap.size() == 0 && minHeap.size() == 0){
	    maxHeap.add(element);
	}
	else{
	    if (element.compareTo(minHeap.peek()) < 0){
		minHeap.add(element);
		if (maxHeap.size() - minHeap.size() >= 2){
		    maxHeap.add(minHeap.remove());
		}
	    }
	    else{
		maxHeap.add(element);
		if (maxHeap.size() - minHeap.size() >= 2){
		    minHeap.add(maxHeap.remove());
		}
	    }
	}
    }
    public Double getMedian(){
	Double ans = 0.0;
	int current = 0;
	if (minHeap.size() >= maxHeap.size()){
	    ans += minHeap[0];
	    current++;
	}
	if (maxHeap.size() > minHeap.size()){
	    ans += maxHeap[0];
	    current++;
	}
	return ans/current;
    }
}
