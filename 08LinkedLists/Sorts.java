import java.util.*;
public class Sorts{
    public static void radixsort(MyLinkedListImproved<Integer> data){
	MyLinkedListImproved<Integer> positiveBucket = new MyLinkedListImproved<>();
	MyLinkedListImproved<Integer> negativeBucket = new MyLinkedListImproved<>();
	for (int i = 0;i<data.size;i++){
	    if (data.getNode(i).getValue() >= 0){
		positiveBucket.add2(data.getNode(i).getValue());
	    }
	    else{
		negativeBucket.add2(data.getNode(i).getValue());
	    }
	}
	if (positiveBucket.size > 1){
	    for (int x = 1;x<positiveBucket.size();x++){
		Integer helper = positiveBucket.getNode(x).getValue();
		Integer helper2 = positiveBucket.getNode(x-1).getValue();
		if (positiveBucket.getNode(x).getValue() < positiveBucket.getNode(x-1).getValue()){
		    Integer temp = positiveBucket.getNode(x).getValue();
		    helper = positiveBucket.getNode(x-1).getValue();
		    helper2 = temp;
		}
	    }
	}
	if (negativeBucket.size > 1){
	    for (int y = 1;y<negativeBucket.size;y++){
		Integer helper = negativeBucket.getNode(y).getValue();
		Integer helper2 = negativeBucket.getNode(y-1).getValue();
		if (negativeBucket.getNode(y).getValue() < negativeBucket.getNode(y-1).getValue()){
		    Integer temp = negativeBucket.getNode(y).getValue();
		    helper = negativeBucket.getNode(y-1).getValue();
		    helper2 = temp;
		}
	    }
	}
	negativeBucket.extend(positiveBucket);
    }
    public static void radixsortIncludingNegatives(MyLinkedListImproved<Integer> data){
	return;
    }
}
