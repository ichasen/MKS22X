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
    private void switch(String element,String el2){
	String temp = element;
	heap[indexOf(element)] = el2;
	heap[indexOf(el2)] = temp;
    }
    private void pushDown(String parent,String child1,String child2,boolean isMaxHeap){
	if (isMaxHeap){
	    if (child1 >= child2){
		switch(parent,child1);
	    }else{
		switch(parent,child2);
	    }
	}else{
	    if (child1 <= child2){
		switch(parent,child1);
	    }else{
		switch(parent,child2);
	    }
	}
    }
}
