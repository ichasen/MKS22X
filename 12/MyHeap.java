public class MyHeap<String extends Comparable<String>>{
    String[] heap;
    @SuppressWarnings("unchecked")
    public MyHeap(){
	heap = (String[]) new Object[0];
    }
    @SuppressWarnings("unchecked")
    public MyHeap(boolean isMaxHeap){
	heap = (String[]) new Object[0];
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
	if (isMaxHeap){
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
}
