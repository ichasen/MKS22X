import java.io.*;
import java.util.*;
public class Sorts<T extends Comparable<T>>{
    public int indexOf(T element,T[] heap){
	for (int i = 0;i<heap.length;i++){
	    if (heap[i] == element){
		return i;
	    }
	}
	return -1;
    }
    private void swap(T[] heap,T parent,T child1){
	T temp = parent;
	heap[indexOf(parent,heap)] = child1;
	heap[indexOf(child1,heap)] = temp;
    }
    public void heapify(T[] data){
	for (int i = 0;i<data.length;i++){
	    if (i * 2 + 1 < data.length && data[i].compareTo( data[i*2+1]) <= 0){
		swap(data,data[i],data[i*2+1]);
	    }
	    if (i * 2 + 2 < data.length && data[i].compareTo( data[i*2+2]) <= 0){
		swap(data,data[i],data[i*2+2]);
	    }
	}
    }
    public void heapsort(T[] data){
	heapify(data);
	for (int i = data.length - 1;i>=0;i--){
	    swap(data,data[0],data[i]);
	    for (int j = 0;j<data.length - 2;j++){
		if (j * 2 + 1 < data.length-1 && data[j].compareTo( data[j*2+1]) <= 0){
		    swap(data,data[j],data[j*2+1]);
		}
		if (j * 2 + 2 < data.length-1 && data[j].compareTo( data[j*2+2]) <= 0){
		    swap(data,data[j],data[j*2+2]);
		}
	    }
	}
    }
}
	    
