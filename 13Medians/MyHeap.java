public class MyHeap<T extends Comparable<T>>{
    double[] heap;
    boolean isMax;
    @SuppressWarnings("unchecked")
    public MyHeap(){
	heap = new double[0];
    }
    @SuppressWarnings("unchecked")
    public MyHeap(boolean isMaxHeap){
	heap = new double [0];
	isMax = isMaxHeap;
    }
    public int indexOf(double element){
	for (int i = 0;i<heap.length;i++){
	    if (heap[i] == element){
		return i;
	    }
	}
	return -1;
    }
    private void pushDown(double parent,double child1,double child2,boolean isMaxHeap){
	if (isMax){
	    if (child1 >= child2){
	        double temp = parent;
		heap[indexOf(parent)] = child1;
		heap[indexOf(child1)] = temp;
	    }
	    else{
		double temp = parent;
		heap[indexOf(parent)] = child2;
		heap[indexOf(child2)] = temp;
	    }
	}
	else{
	    if (child1 <= child2){
		double temp = parent;
		heap[indexOf(parent)] = child1;
		heap[indexOf(child1)] = temp;
	    }
	    else{
	        double temp = parent;
		heap[indexOf(parent)] = child2;
		heap[indexOf(child2)] = temp;
	    }
	}
    }
    public double peek(){
	return heap[0];
    }
    public int size(){
	return heap.length;
    }
    public void add(double element){
	@SuppressWarnings("unchecked") double[] heap2 = new double[heap.length + 1];
	for (int i = 0;i<heap.length;i++){
	    heap2[i] = heap[i];
	}
	heap2[heap2.length - 1] = element;
	if (isMax){
	    if (heap2[(heap2.length - 2)/2] < element){
		pushDown(heap2[(heap2.length - 2)/2],element,heap2[heap2.length - 2],true);
	    }
	}
	else{
	    if (heap2[(heap2.length - 2)/2] > element){
		pushDown(heap2[(heap2.length - 2)/2],element,heap2[heap2.length - 2],false);
	    }
	}
    }
    public double remove(){
	double ans = heap[heap.length - 1];
	@SuppressWarnings("unchecked") double[] heap2 = new double[heap.length - 1];
	for (int i = 0;i<heap2.length;i++){
	    heap2[i] = heap[i];
	}
	return ans;
    }
}
