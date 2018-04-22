import java.util.*;
import java.io.*;
public class MyDeque<E>{
    E[] data;
    int firstIndex;
    int lastIndex;
    @SuppressWarnings("unchecked")
    public MyDeque(){
	data = (E[])new Object[10];
    }
    @SuppressWarnings("unchecked")
    public MyDeque(int initialCapacity){
	if (initialCapacity < 0){
	    throw new IllegalArgumentException();
	}
	data = (E[])new Object[initialCapacity];
    }
    public int size(){
	return data.length;
    }
    public void addFirst(E element){
	if (element == null){
	    throw new NullPointerException();
	}
	@SuppressWarnings("unchecked") E[] data2 = (E[]) new Object[data.length + 1];
	if (firstIndex == 0){
	    data2[0] = element;
	    for (int i = 1;i<data2.length;i++){
		data2[i] = data[i];
	    }
	}
	else{
	    data[firstIndex] = element;
	    for (int i = firstIndex+1;i<data2.length;i++){
		data2[i] = data[i-1];
	    }
	    for (int j = 0;j<firstIndex;j++){
		data2[j] = data[j];
	    }
	}
	data = data2;
    }
    public void addLast(E element){
	if (element == null){
	    throw new NullPointerException();
	}
	@SuppressWarnings("unchecked") E[] data2 = (E[]) new Object[data.length + 1];
	if (lastIndex == data.length -1){
	    data2[data.length] = element;
	    lastIndex = indexOf(element);
	}
	else{
	    data2[lastIndex+1] = element;
	    for (int i = lastIndex+1;i<data2.length;i++){
		data2[i] = data[i-1];
	    }
	    for(int j = 0;j<lastIndex+1;j++){
		data2[j] = data[j];
	    }
	    lastIndex = indexOf(element);
	}
	data = data2;
    }
    public E removeFirst(){
	if (data.length == 0){
	    throw new NoSuchElementException();
	}
	E ans = data[firstIndex];
	@SuppressWarnings("unchecked") E[] data2 = (E[]) new Object[data.length - 1];
	if (firstIndex == 0){
	    for (int i = 0;i<data2.length;i++){
		data2[i] = data[i+1];
	    }
	}
	else{
	    for (int j = firstIndex;j<data2.length;j++){
		data2[j] = data[j+1];
	    }
	    for(int x = 0;x<firstIndex;x++){
		data2[x] = data[x];
	    }
	}
	data = data2;
	return ans;
    }
    public E removeLast(){
	if (data.length == 0){
	    throw new NoSuchElementException();
	}
	E ans = data[lastIndex];
	@SuppressWarnings("unchecked") E[] data2 = (E[]) new Object[data.length - 1];
	if (lastIndex == data.length-1){
	    for (int i = 0;i<lastIndex;i++){
		data2[i] = data[i];
	    }
	    lastIndex = data2.length - 1;
	}
	if (lastIndex == 0){
	    for (int j = 0;j<data2.length;j++){
		data2[j] = data[j+1];
	    }
	    lastIndex = data2.length - 1;
	    if (firstIndex != 0){
		firstIndex -= 1;
	    }
	}
	else{
	    for (int x = firstIndex - 1;x<data2.length;x++){
		data2[x] = data[x+1];
	    }
	    for (int y = 0;y<lastIndex;y++){
		data2[y] = data[y];
	    }
	    firstIndex -= 1;
	    lastIndex -= 1;
	}
	data2 = data;
	return ans;
    }
    public E getFirst(){
	if (data.length == 0){
	    throw new NoSuchElementException();
	}
	return data[firstIndex];
    }
    public E getLast(){
	if (data.length == 0){
	    throw new NoSuchElementException();
	}
	return data[lastIndex];
    }
    private int indexOf(E element){
	if (element == null){
	    throw new NullPointerException();
	}
	for (int i = 0;i<data.length;i++){
	    if (data[i] == element){
		return i;
	    }
	}
	return -1;
    }
    public String toString(){
    String ans = "[";
    if(firstIndex < lastIndex){
      for (int i = firstIndex; i <= lastIndex; i++){
        ans += data[i] + " , ";
      }
    }
    else{
      for(int i = firstIndex; i < data.length; i++){
        ans += data[i] + ", ";
      }
      for(int i = 0; i <= lastIndex; i++){
        ans += data[i] + ", ";
      }
    }
    ans = ans.substring(0, ans.length() - 2) + "]";
    return ans;
  }

  public static void main(String[] args) {
    MyDeque<String> a = new MyDeque<>(), a1 = new MyDeque<>();
    ArrayList<String> b = new ArrayList<>();

    int size = Integer.parseInt(args[0]);
    for(int i = 0; i < size; i++){
      int temp = (int)(Math.random() * 1000);
      if(temp % 2 == 0){
        a.addFirst("" + temp);
        a1.addFirst("" + temp);
        b.add(0, "" + temp);
      }
      else{
        a.addLast("" + temp);
        a1.addLast("" + temp);
        b.add("" + temp);
      }
    }

    int index = 0;
    boolean hasError = false;
    String errorEvaluation = "Errors found at these indices: ";
    for (String x : b){
      if (!(x.equals(a.getFirst()))){
        System.out.println("The getFirst() function is incorrect at index " + index);
        hasError = true;
      }
      if (!(x.equals(a.removeFirst()))){
        System.out.println("There is an error at index " + index);
        errorEvaluation += index + ", ";
        hasError = true;
      }
      index++;
    }


    if(hasError){
      errorEvaluation = errorEvaluation.substring(0, errorEvaluation.length() - 2);
      System.out.println(errorEvaluation);
      System.out.println("MyDeque: " + a1);
      System.out.println("Actual Deque: " + b);
    }
    else{
      System.out.println("Your deque is bug-free!");
    }
  }
}
	
