public class Recursion{
    public int fact(int n){
	return factHelp (n,1);
    }
    public int factHelp(int n,int ans){
	if (n == 0 || n == 1){
	    return ans;
	}
	return factHelp (n - 1,ans * n);
    }
    public int fib (int n){
	return fibHelp (n,0,1,0);
    }
    public int fibHelp (int n,int current, int next, int ans){
	for (int i = 0;i<n;i++){
	    ans = current + next;
	    current = next;
	    ans = next;
	}
	return ans;
    }
    public double sqrt(double n){
	return sqrtHelp(n,1);
    }
    public double sqrtHelp(double n,double guess){
	if ((guess / (1/n)) >= .9999 || (guess / (1/n)) <= 1.0001){
	    return guess;
	}
	return sqrtHelp (n, (n / guess + guess / 2));
    }
}
