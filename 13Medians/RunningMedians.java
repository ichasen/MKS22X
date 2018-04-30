public class RunningMedians{
    MyHeap maxHeap = new MyHeap();
    MyHeap minHeap = new MyHeap();
    public void add(Integer element){
	if (maxHeap.length == 0 && minHeap.length == 0){
	    maxHeap.add(element);
	}
    }
}
