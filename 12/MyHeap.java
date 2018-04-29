public class MyHeap<String extends Comparable<String>>{
    String[] heap;
    boolean isMax;
    @SuppressWarnings("unchecked")
    public MyHeap(){
	heap = (String[]) new Comparable[0];
    }
    @SuppressWarnings("unchecked")
    public MyHeap(boolean isMaxHeap){
	heap = (String[]) new Object[0];
	isMax = isMaxHeap;
    }
    public int indexOf(String element){
	for (int i = 0;i<heap.length;i++){
	    if (heap[i] == element){
		return i;
	    }
	}
	return -1;
    }
    private void pushDown(String parent,String child1,String child2,boolean isMaxHeap){
	if (isMax){
	    if (child1.compareTo(child2) >= 0){
	        String temp = parent;
		heap[indexOf(parent)] = child1;
		heap[indexOf(child1)] = temp;
	    }
	    else{
		String temp = parent;
		heap[indexOf(parent)] = child2;
		heap[indexOf(child2)] = temp;
	    }
	}
	else{
	    if (child1.compareTo(child2) <= 0){
		String temp = parent;
		heap[indexOf(parent)] = child1;
		heap[indexOf(child1)] = temp;
	    }
	    else{
	        String temp = parent;
		heap[indexOf(parent)] = child2;
		heap[indexOf(child2)] = temp;
	    }
	}
    }
    public String peek(){
	return heap[0];
    }
    public int size(){
	return heap.length;
    }
    public void add(String element){
	@SuppressWarnings("unchecked") String[] heap2 = (String[]) new Comparable[heap.length + 1];
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
    public String remove(){
	String ans = heap[heap.length - 1];
	@SuppressWarnings("unchecked") String[] heap2 = (String[]) new Comparable[heap.length - 1];
	for (int i = 0;i<heap2.length;i++){
	    heap2[i] = heap[i];
	}
	return ans;
    }
}
