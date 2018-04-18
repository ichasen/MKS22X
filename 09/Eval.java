public class Eval{
    public static double eval (String stuff){
	String[] numsAndOps = stuff.split(" ");
	String ops = "+-*/%";
	Stack nums = new Stack();
	Double ans = 0.0;
	for (int x = 0;x<nums.length;x++){
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
	    
		
    
