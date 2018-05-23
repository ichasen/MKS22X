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
	    pushUp(i,data,true);
	}
    }
    public void pushUp(int x,T[] heap,boolean isMax){
	int parent = (x-1)/2;
	if (isMax){
	    if (parent>=0){
		if (heap[x].compareTo(heap[parent]) > 0){
		    swap(heap,heap[x],heap[parent]);
		    pushUp(parent,heap,true);
		}

	    }
	    
	}
	else{
	    if (parent>=0){
		if (heap[x].compareTo(heap[parent]) < 0){
		    swap(heap,heap[x],heap[parent]);
		    pushUp(parent,heap,true);
		}

	    }
	}
    }
}
	    
