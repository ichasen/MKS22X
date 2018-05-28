import java.io.*;
import java.util.*;
public class MazeSolver{
    private Maze maze;
    private Frontier frontier;
    private String newMaze;
    private boolean aStar;
    public MazeSolver(String mazeText){
	maze = new Maze(mazeText);
	newMaze = mazeText;
    }
    //Default to BFS
    public boolean solve(){ return solve(0); }

    //mode: required to allow for alternate solve modes.
    //0: BFS
    //1: DFS
    public boolean solve(int mode){
	//initialize your frontier
	//while there is stuff in the frontier:
	//  get the next location
	//  process the location to find the locations (use the maze to do this)
	//  check if any locations are the end, if you found the end just return true!
	//  add all the locations to the frontier
	//when there are no more values in the frontier return false

	if(mode == 0){
	    frontier = new FrontierQueue();
	}
	else if(mode == 1){
	    frontier = new FrontierStack();
	}
	else if(mode == 2){
	    frontier = new FrontierPriorityQueue();
	}
	else if(mode == 3){
	    maze = new Maze(newMaze, true);
	    frontier = new FrontierPriorityQueue();
	}
	frontier.add(maze.getStart());
	while(frontier.hasNext()){
	    Location current = frontier.next();
	    if (current.getx() == maze.getEnd().getx() && current.gety() == maze.getEnd().gety()){
		maze.set(current.getx(),current.gety(), 'E');
		while (current.getPrev() != null){
		    Location prev = current.getPrev();
		    maze.set(prev.getx(),prev.gety(), '@');
		    current = prev;
		}
		maze.set(maze.getStart().getx(), maze.getStart().gety(), 'S');
		return true;
	    }
	    maze.set(current.getx(), current.gety(), '.');
	    Location[] neighbors = maze.getNeighbors(current);
	    for(Location neighbor:neighbors){
		try{
		    maze.set(neighbor.getx(),neighbor.gety(), '?');   
		    frontier.add(neighbor);
		}
		catch(NullPointerException e){}
	    }
	}
	return false;
    }

    public String toString(){
	return maze.toString();
    }
}
