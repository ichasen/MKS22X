public class StackCalc{
    public static double eval (String stuff){
	String[] numsAndOps = stuff.split(" ");
	String ops = "+-*/%";
	StackClass nums = new StackClass();
	Double ans = 0.0;
	for (int x = 0;x<numsAndOps.length;x++){
	    String current = numsAndOps[x];
	    if (current.equals("+")){
		ans += nums.pop() + nums.pop();
	    }
	    if (current.equals("-")){
		ans += nums.pop() - nums.pop();
	    }
	    if (current.equals("*")){
		ans += nums.pop() * nums.pop();
	    }
	    if (current.equals("/")){
		ans += nums.pop() / nums.pop();
	    }
	    if (current.equals("%")){
		ans += nums.pop() % nums.pop();
	    }
	}
	return ans;
    }
}
	    
		
    
