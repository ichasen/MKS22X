public class Merge{
    public static void mergesort(int[] data){
	int[] temp = new int [data.length];
	msort(data,temp,0,data.length);
    }
    public static void msort(int[] data, int[] temp, int lo, int hi){
	if (lo >= hi){
	    return;
	}
	int mid = (lo + hi)/2;
	msort(temp,data,lo,mid);
	msort(temp,data,mid+1,hi);
	merge(data,temp,lo,mid,hi);
    }
    public static void merge(int[] data,int[] temp,int lo,int mid,int hi){
	int x = mid+1;
	for(int i=0,j=mid+1;i<mid && j<hi;i++){
	    if (temp[i]<=temp[j]){
		data[i] = temp[i];
	    }
	    else{
		data[i] = temp[j];
	    }
	}
    }
}
