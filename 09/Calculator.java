import java.util.*;
import java.io.*;
public class Calculator{
    public static double eval (String stuff){
	String[] numsAndOps = stuff.split(" ");
	LinkedList<Double> nums = new LinkedList<>();
	for (int x = 0;x<numsAndOps.length;x++){
	    if (numsAndOps[x].equals("+")){
		double first = nums.pop();
		double second = nums.pop();
		nums.push(first + second);
	    }
	    else if (numsAndOps[x].equals("-")){
		double first = nums.pop();
		double second = nums.pop();
	        nums.push(second - first);
	    }
	    else if (numsAndOps[x].equals("*")){
		double first = nums.pop();
		double second = nums.pop();
	        nums.push(first * second);
	    }
	    else if (numsAndOps[x].equals("/")){
		double first = nums.pop();
		double second = nums.pop();
	        nums.push(second / first);
	    }
	    else if (numsAndOps[x].equals("%")){
		double first = nums.pop();
		double second = nums.pop();
	        nums.push(second % first);
	    }
	    else{
		nums.push(Double.parseDouble(numsAndOps[x]));
	    }
	}
	return nums.pop();
    }
}
	    
		
    
