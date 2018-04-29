public class MyHeap<T extends Comparable<T>>{
    T[] heap;
    boolean isMax;
    @SuppressWarnings("unchecked")
    public MyHeap(){
	heap = (T[]) new Comparable[0];
    }
    @SuppressWarnings("unchecked")
    public MyHeap(boolean isMaxHeap){
	heap = (T[]) new Object[0];
	isMax = isMaxHeap;
    }
    public int indexOf(T element){
	for (int i = 0;i<heap.length;i++){
	    if (heap[i] == element){
		return i;
	    }
	}
	return -1;
    }
    private void pushDown(T parent,T child1,T child2,boolean isMaxHeap){
	if (isMax){
	    if (child1.compareTo(child2) >= 0){
	        T temp = parent;
		heap[indexOf(parent)] = child1;
		heap[indexOf(child1)] = temp;
	    }
	    else{
		T temp = parent;
		heap[indexOf(parent)] = child2;
		heap[indexOf(child2)] = temp;
	    }
	}
	else{
	    if (child1.compareTo(child2) <= 0){
		T temp = parent;
		heap[indexOf(parent)] = child1;
		heap[indexOf(child1)] = temp;
	    }
	    else{
	        T temp = parent;
		heap[indexOf(parent)] = child2;
		heap[indexOf(child2)] = temp;
	    }
	}
    }
    public T peek(){
	return heap[0];
    }
    public int size(){
	return heap.length;
    }
    public void add(T element){
	@SuppressWarnings("unchecked") T[] heap2 = (T[]) new Comparable[heap.length + 1];
	for (int i = 0;i<heap.length;i++){
	    heap2[i] = heap[i];
	}
	heap2[heap2.length - 1] = element;
	if (isMax){
	    if (heap2[(heap2.length - 2)/2].compareTo(element) < 0){
		pushDown(heap2[(heap2.length - 2)/2],element,heap2[heap2.length - 2],true);
	    }
	}
	else{
	    if (heap2[(heap2.length - 2)/2].compareTo(element) > 0){
		pushDown(heap2[(heap2.length - 2)/2],element,heap2[heap2.length - 2],false);
	    }
	}
    }
    public T remove(){
	T ans = heap[heap.length - 1];
	@SuppressWarnings("unchecked") T[] heap2 = (T[]) new Comparable[heap.length - 1];
	for (int i = 0;i<heap2.length;i++){
	    heap2[i] = heap[i];
	}
	return ans;
    }
}
