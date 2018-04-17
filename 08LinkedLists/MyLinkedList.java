import java.util.LinkedList;
public class MyLinkedList{
    Node start;
    Node end;
    int size;
    public MyLinkedList(){
	size = 0;
    }
    private Node getNode(int index){
	int current = 0;
	Node n = start;
	while(current < index){
	    n = n.getNext();
	    current++;
	}
	return n;
    }
    public int size(){
	return size;
    }
    public Integer get(int index){
	if (index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}
	return getNode(index).getValue();
    }
    public Integer set(int index,int newValue){
	if (index < 0 || index > size){
	    throw new IndexOutOfBoundsException();
	}
	Node n = getNode(index);
	Integer ans = n.getValue();
        n.setValue(newValue);
	return ans;
    }
    public String toString(){
	String ans = "[";
	for (int i = 0;i<size;i++){
	    ans += get(i);
	    ans += ",";
	}
	ans += "]";
	return ans;
    }
    public boolean add(int value){
	Node n = new Node();
	n.setValue(value);
	if (size == 0){
	    start = n;
	    end = start;
	}
	else if (size == 1){
	    end = n;
	    start.setNext(end);
	    end.setPrev(start);
	}
	else{
	    end.setNext(n);
	    n.setPrev(end);
	    end = n;
	}
	return true;
    }
    public void clear(){
	size = 0;
	start = null;
	end = start;
    }
    public int indexOf(Integer value){
	for (int i = 0;i<size;i++){
	    if (getNode(i).getValue() == value){
		return i;
	    }
	}
	return -1;
    }
    public void add(int index,Integer value){
	if (index > size || index < 0){
	    throw new IndexOutOfBoundsException();
	}
	Node n = new Node();
	n.setValue(value);
	if (index == size){
	    add(value);
	    size++;
	}
	else if (index == 0){
	    n.setNext(start);
	    start.setPrev(n);
	    n.setNext(start);
	    start = n;
	    size++;
	}
	else{
	    Node x = getNode(index-1);
	    Node y = getNode(index);
	    n.setPrev(x);
	    n.setNext(y);
	    x.setNext(n);
	    y.setPrev(n);
	    size++;
	}
    }
    public boolean remove(Integer value){
	if (indexOf(value) < 0 || indexOf(value) >= size){
	    return false;
	}
	remove(indexOf(value));
	return true;
    }
    public Integer remove (int index){
	if (index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}
	Integer i = getNode(index).getValue();
	if (index == 0){
	    start = start.getNext();
	    start.setPrev(null);
	}
	else if (index == size - 1){
	    end = end.getPrev();
	    end.setNext(null);
	}
	else{
	    Node x = getNode(index - 1);
	    Node y = getNode (index + 1);
	    x.setNext(y);
	    y.setPrev(x);
	}
	size--;
	return i;
    }
    private class Node{
	Node next;
	Node prev;
	int data;
	public Node getNext(){
	    return next;
	}
	public Node getPrev(){
	    return prev;
	}
	public void setNext(Node newValue){
	    next = newValue;
	}
	public void setPrev(Node newValue){
	    prev = newValue;
	}
	public Integer getValue(){
	    return data;
	}
	public void setValue(Integer newValue){
	    data = newValue;
	}
	public String toString(){
	    String ans = "";
	    ans += data;
	    ans += "Previous: " + prev + "/n" + "Current: " + data + "/n" +  "Next: " + next;
	    return ans;
	}
    }
    public static void main(String[]args){
      MyLinkedList nums = new MyLinkedList();
      LinkedList<Integer> nums2 = new LinkedList<>();
      
      for(int i = 0; i < 2000; i++  ){
        int index = (int)(Math.random()*(1 + nums.size()));
        nums.add(index,i);
        nums2.add(index,i);
      }
      for(int i = 0; i < nums.size(); i++  ){
        if(nums.get(i) != nums2.get(i).intValue()){
          System.out.println("FAIL Randomized adds location: "+i+" "+nums.get(i)+" vs "+nums2.get(i));
          return;
        }
      }
      System.out.println("PASS Randomized adds");
      
      int max = nums.size();
      for(int i = 0; i < max/2; i++  ){
        if(nums.remove(i)!=nums2.remove(i).intValue()){
          System.out.println("FAIL while removing index: "+i);
          return;
        }
      }
      nums.remove(0);
      nums2.remove(0);
      nums.remove(nums.size()-1);
      nums2.remove(nums2.size()-1);
      
      for(int i = 0; i < nums.size(); i++  ){
        if(nums.get(i)!=nums2.get(i).intValue()){
          System.out.println("FAIL consecutive removes");
          return;
        }
      }
      System.out.println("PASS consecutive removes");
      
      
      for(int i = 0; i < 1000; i++  ){
        int index = (int)(Math.random()*(1 + nums.size()));
        nums.add(index,i);
        nums2.add(index,i);
      }
      for(int i = 0; i < nums.size(); i++  ){
        if(nums.get(i) != nums2.get(i).intValue()){
          System.out.println("FAIL Randomized adds location: "+i+" "+nums.get(i)+" vs "+nums2.get(i));
          return;
        }
      }
      System.out.println("PASS Randomized adds phase 2");
      
      
      max = nums.size();
      for(int i = 0; i < max/2; i++  ){
        int index = (int)(Math.random()*nums.size());
        if(nums.remove(index)!=nums2.remove(index).intValue()){
          System.out.println("FAIL while removing index: "+index);
          return;
        }
      }
      nums.remove(0);
      nums2.remove(0);
      nums.remove(nums.size()-1);
      nums2.remove(nums2.size()-1);
      
      for(int i = 0; i < nums.size(); i++  ){
        if(nums.get(i)!=nums2.get(i).intValue()){
          System.out.println("FAIL randomized removes");
          return;
        }
      }
      System.out.println("PASS randomized removes");
      
      //get-------------------
      try{
        nums.get(-3);
        System.out.println("FAIL get access negative index did not throw exception");
        return;
      }catch(IndexOutOfBoundsException e){
        System.out.println("PASS get out of bounds negateive index ");
      }
      
      try{
        nums.get(nums.size());
        System.out.println("FAIL get access index too large did not throw exception");
        return;
      }catch(IndexOutOfBoundsException e){
        System.out.println("PASS get out of bounds index too large");
      }
      
      
      //set-------------------
      try{
        nums.set(-3,5);
        System.out.println("FAIL set access negative index did not throw exception");
        return;
      }catch(IndexOutOfBoundsException e){
        System.out.println("PASS set out of bounds negateive index ");
        
      }
      
      try{
        nums.set(nums.size(),5);
        System.out.println("FAIL set access index too large did not throw exception");
        return;
      }catch(IndexOutOfBoundsException e){
        System.out.println("PASS set out of bounds index too large");
      }
      
      
      
      //add-------------------
      try{
        nums.add(nums.size()+1,5);
        System.out.println("FAIL add access index too large did not throw exception");
        return;
      }catch(IndexOutOfBoundsException e){
        System.out.println("PASS add out of bounds index too large");
      }
      
      try{
        nums.add(-1,5);
        System.out.println("FAIL add access negative index did not throw exception");
        return;
      }catch(IndexOutOfBoundsException e){
        System.out.println("PASS add out of bounds negative index");
      }
      
      
      
      //remove-------------------
      try{
        nums.remove(nums.size()+1);
        System.out.println("FAIL remove access index too large did not throw exception");
        return;
      }catch(IndexOutOfBoundsException e){
        System.out.println("PASS remove out of bounds index too large");
      }
      
      try{
        nums.remove(-1);
        System.out.println("FAIL remove access index too large did not throw exception");
        return;
      }catch(IndexOutOfBoundsException e){
        System.out.println("PASS remove out of bounds index too large");
      }
      
      
      //
      nums.clear();
      if(nums.size()==0){
        System.out.println("PASS clear");
      }else{
        System.out.println("FAIL clear");
        return;
      }
      
      
      
      //REMOVE BY VALUE (not index)
      nums.clear();
      for(int i = 0; i < 10; i++){
        nums.add(0,Integer.valueOf(i));
      }
      if(nums.remove(Integer.valueOf(0)) && nums.remove(Integer.valueOf(1)) &&
      nums.remove(Integer.valueOf(5)) && nums.remove(Integer.valueOf(3)) &&
      nums.remove(Integer.valueOf(8))&& nums.remove(Integer.valueOf(9)))  {
        try{
          int[]result = { 7, 6, 4, 2};
          for(int i = 0; i < nums.size();i++ ){
            if(result[i]!=nums.get(i).intValue()){
              System.out.println("FAIL to remove by value. Final State bad");
              return;
            }
          }
        }catch(Exception e){
          System.out.println("FAIL to remove by value. Exception thrown");
          return;
        }
      }else{
        System.out.println("FAIL to remove by value.");
        return;
      }
      System.out.println("PASS remove by values (Integer, not int).");
      
      nums.clear();
      long end,start = System.currentTimeMillis();
      
      System.out.println("#Adding to 100000 values to the front, and 100000 to the end, should be fast.\n#If the next line doesn't print right away you have some issues.");
      for(int i = 0; i < 100000; i++  ){
        nums.add(i);
        nums.add(nums.size(),i);
      }
      end = System.currentTimeMillis();
      //mine was 8msec on a laptop, so 250 should be fine!
      if(end - start > 250){
        System.out.println("FAIL! Should be much faster than "+(end-start)+"msec");
        return;
      }else{
        System.out.println("PASS "+ (end-start)+" msec current size: "+nums.size());
      }
    }
}
