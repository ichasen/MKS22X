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
    public void pushUp(int x){
	int parent = (x-1)/2;
	if (isMax){
	    if (parent>=0){
		if (heap[x].compareTo(heap[parent]) > 0){
		    swap(x,parent);
		    pushUp(parent);
		}

	    }
	    
	}
	else{
	    if (parent>=0){
		if (heap[x].compareTo(heap[parent]) < 0){
		    swap(x,parent);
		    pushUp(parent);
		}

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
	pushUp(size-1);
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
	for (int i = 0;i<heap.length-1;i++){
	    heap2[i] = heap[i];
	}
	return ans;
    }
    public String toString(){
	String ans = "[";
	for (int i = 0;i<heap.length;i++){
	    if (heap[i] != null){
		ans += heap[i] + ", ";
	    }
	}
	ans = ans.substring(0,ans.length()-2) + "]";
	return ans;
    }
    public static void main(String[] args){
	MyHeap<Integer> ex = new MyHeap<>(false);
	ex.add(2);
	ex.add(3);
	System.out.println(ex.toString());
	ex.add(5);
	System.out.println(ex.toString());
	ex.add(4);
	System.out.println(ex.toString());
	ex.add(10);
	ex.add(1);
	System.out.println(ex.toString());
	ex.remove();
	System.out.println(ex.toString());
    }
}
