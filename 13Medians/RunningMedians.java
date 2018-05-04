public class RunningMedians{
    MyHeap maxHeap = new MyHeap<Double>();
    MyHeap minHeap = new MyHeap<Double>();
    public void add(Double element){
	if (maxHeap.size() == 0 && minHeap.size() == 0){
	    maxHeap.add(element);
	}
	else if (element.compareTo(maxHeap.peek()) > 0){
	    minHeap.add(element);
	    if (minHeap.size() - maxHeap.size() > 1){
		resize(maxHeap,minHeap);
	    }
	}
	else{
	    minHeap.add(element);
	    if (maxHeap.size() - minHeap.size() > 1){
		resize(minHeap,maxHeap);
	    }
	}
    }
    public void resize(MyHeap<Double> heap1, MyHeap<Double> heap2){
        heap1.add(heap2.remove());
    }
    public Double getMedian(){
	if (maxHeap.size() - minHeap.size() == 1){
	    return maxHeap.peek();
	}
	else if(minHeap.size() - maxHeap.size() == 1){
	    return minHeap.peek();
	}
	else{
	    return (minHeap.peek() + maxHeap.peek()) / 2;
	}
    }
    public int size(){
	return minHeap.size() + maxHeap.size();
    }
}
