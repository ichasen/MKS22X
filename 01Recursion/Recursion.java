import java.lang.Math;
public class Recursion{
    public int fact(int n){
	return factHelp (n,1);
    }
    public int factHelp(int n,int ans){
	if (n < 0){
	    throw new IllegalArgumentException("Enter a number >= 0");
	}
	if (n == 0 || n == 1){
	    return ans;
	}
	return factHelp (n - 1,ans * n);
    }
    public int fib (int n){
        return fibHelp(n,0,1);
    }
    public int fibHelp (int n,int current,int next){
	if (n == 0){
	    return current;
	}
	return fibHelp(n-1,next,current+next);
    }
    public double sqrt(double n){
	if (n<0){
	    throw new IllegalArgumentException("Enter number greater than zero");
	}
	return sqrtHelp(n,1.0);
    }
    public double sqrtHelp(double n,double guess){
	if (n == 0){
	    return 0;
	}
	if (n == 1){
	    return 1;
	}
	if (Math.abs((guess * guess - n) / n) < 0.00001){
	    return guess;
	}
        return sqrtHelp (n, (n / guess + guess) / 2);
    }
}
