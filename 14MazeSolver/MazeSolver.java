import java.io.*;
import java.util.*;
public class MazeSolver{
    private Maze maze;
    private Frontier frontier;
    private boolean aStar;
    public MazeSolver(String mazeText){
	maze = new Maze(mazeText);
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
	if (mode == 0){
	    frontier = new FrontierQueue();
	}
	if (mode == 1){
	    frontier = new FrontierStack();
	}
	if (mode == 2){
	    frontier = new FrontierPriorityQueue();
	}
	frontier.add(maze.getStart());
	while(frontier.hasNext()){
	    Location current = frontier.next();
	    Location[] neighbors = maze.getNeighbors(current);
	    for (int i = 0;i<neighbors.length;i++){
		if (neighbors[i] != null){
		    frontier.add(neighbors[i]);
		    if (neighbors[i].getX() == maze.getEnd().getX() && neighbors[i].getY() == maze.getEnd().getY()){
		        if (current.getPrev() != null){
			    maze[current.getX()][current.getY()] = '@';
			}
			if (aStar){
			    for (Location l = current;l != start;l = l.getPrev()){
				l.distance++;
			    }
			}
			return true;
		    }
		}
	    }
	}
	return false;
    }

    public String toString(){
	return maze.toString();
    }
}
