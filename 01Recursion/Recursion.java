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
	int current = 0;
	int next = 1;
	int ans = 0;
	for (int i = 0;i<n;i++){
	    ans = current + next;
	    current = next;
	    next = ans;
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
