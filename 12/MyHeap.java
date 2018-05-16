import java.io.*;
import java.util.*;
public class MyHeap<T extends Comparable<T>>{
    T[] heap;
    boolean isMax;
    int size;
    @SuppressWarnings("unchecked")
    public MyHeap(){
	heap = (T[]) new Comparable[10];
	size = 0;
    }
    @SuppressWarnings("unchecked")
    public MyHeap(boolean isMaxHeap){
	heap = (T[]) new Comparable[10];
	isMax = isMaxHeap;
	size = 0;
    }
    public int indexOf(T element){
	for (int i = 0;i<heap.length;i++){
	    if (heap[i] == element){
		return i;
	    }
	}
	return -1;
    }
    private void pushDown(int parent){
	int child1 = parent*2 + 1;
	int child2 = parent*2 + 2;
	if (isMax){
	    if (heap[child1].compareTo(heap[parent]) >= 0 && child1 < size && child2 < size){
	        swap(parent,child1);
		pushDown(child1);
	    }
	    else if (child1 < size && child2 < size){
		swap(parent,child2);
		pushDown(child2);
	    }
	}
	else{
	    if (child1 < size && child2 < size){
		if (heap[child1].compareTo(heap[parent]) <= 0){
		    swap(parent,child1);
		    pushDown(child1);
		}
	    }
	    else if (child1 < size && child2 < size){
	        swap(parent,child2);
		pushDown(child2);
	    }
	}
    }
    public void swap(int i,int j){
	T temp = heap[i];
	heap[i] = heap[j];
	heap[j] = temp;
    }
    public T peek(){
	return heap[0];
    }
    public int size(){
	return size;
    }
    public void add(T element){
	if (size == heap.length){
	    @SuppressWarnings("unchecked") T[] heap2 = (T[]) new Comparable[heap.length + 1];
	    for (int i = 0;i<heap.length;i++){
		heap2[i] = heap[i];
	    }
	    heap = heap2;
	}
	size++;
	heap[size-1] = element;
	pushDown(0);
    }
    public T remove(){
	T ans;
	if (heap.length > 1){
	    ans = heap[heap.length-1];
	}
	else{
	    ans = heap[0];
	}
	@SuppressWarnings("unchecked") T[] heap2 = (T[]) new Comparable[heap.length - 1];
	for (int i = 0;i<heap2.length;i++){
	    heap2[i] = heap[i];
	}
	return ans;
    }
}
