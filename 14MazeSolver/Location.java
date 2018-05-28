public class Location implements Comparable<Location>{
    private int x,y,distance,distanceSoFar;
    private Location previous;

    public Location(int _x, int _y, Location prev){
	x = _x;
	y = _y;
	previous = prev;
    }
    public int getDSoFar(){
	return distanceSoFar;
    }
    public int getx(){
	return x;
    }
    public int gety(){
	return y;
    }
    public int getDistance(){
	return distance;
    }
    public Location getPrev(){
	return previous;
    }
    public void setDSoFar(int n){
	distanceSoFar = n;
    }
    public void move(){
	distanceSoFar++;
    }
    public int compareTo(Location other){
	if (other == null){
	    throw new NullPointerException();
	}
	if (other.getDistance() > this.getDistance()){
	    return -1;
	}
	if (other.getDistance() == this.getDistance()){
	    return 0;
	}
	else{
	    return 1;
	}
    }
}
