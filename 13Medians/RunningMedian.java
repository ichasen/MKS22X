import java.util.*;
import java.io.*;
public class RunningMedian{
    MyHeap<Double> maxHeap = new MyHeap<Double>();
    MyHeap<Double> minHeap = new MyHeap<Double>(false);
    public void add(Double element){
	if (maxHeap.size() == 0 && minHeap.size() == 0){
	    minHeap.add(element);
	}
	else{
	    if (element > minHeap.peek()){
		maxHeap.add(element);
		if (maxHeap.size() - minHeap.size() >= 2){
		    minHeap.add(maxHeap.remove());
		}
	    }
	    else{
		minHeap.add(element);
		if (minHeap.size() - maxHeap.size() >= 2){
		    maxHeap.add(minHeap.remove());
		}
	    }
	}
    }
    public Double getMedian(){
	if (minHeap.size() > maxHeap.size()){
	    return minHeap.peek();
	}
	if (maxHeap.size() > minHeap.size()){
	    return maxHeap.peek();
	}
	else{
	    return (minHeap.peek() - maxHeap.peek()) / 2;
	}
    }
}
