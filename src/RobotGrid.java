import java.awt.Point;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * Problem Statement: (Problem 8.2 Cracking the coding interview, 6th ed)
 * Imagine a robot sitting on the upper left corner of grid 
 * with r rows and columns. The robot can only move in two 
 * directions, right and down, but certain cells are off 
 * limits such that the robot cannot step on them. Design an
 * algorithm to find a bath for the robot from the top left to bottom right.
 *  
 * @author lethai
 *
 */
public class RobotGrid {
	final static int grid_rows = 100;
	final static int grid_cols = 100;
	static ArrayList<Point> moves = new ArrayList<Point>();
	public enum Move {RIGHT, DOWN, STOP, STUCK};
	
	public static void main(String[] args)
	{
		Point origin = new Point(0, 0);
		Point destination = new Point(grid_rows - 1,grid_rows - 1);
		
		HashSet<Point> offgrid = new HashSet<Point>();
		offgrid.add(new Point(1,0));
		offgrid.add(new Point(2,1));
		offgrid.add(new Point(3,2));
		offgrid.add(new Point(1,3));
		offgrid.add(new Point(6,3));
		offgrid.add(new Point(3,4));
		offgrid.add(new Point(4,4));
		offgrid.add(new Point(6,4));
		offgrid.add(new Point(1,5));
		offgrid.add(new Point(2,5));
		offgrid.add(new Point(6,5));
		offgrid.add(new Point(7,5));
		offgrid.add(new Point(5,7));
		offgrid.add(new Point(0,4));
		offgrid.add(new Point(3,3));
		moveNext(origin, destination, offgrid);
		if(moves.size() == 0) System.out.println("Maze is blocked");
		for(Point p:moves) System.out.println(p);
	}
	
	public static boolean moveNext(Point pos, Point dest, HashSet<Point> offgrid)
	{
//		System.out.println("MOVE " + pos);
		moves.add(pos);
		
		boolean isAtDest = (pos.x == dest.x) && (pos.y == dest.y);
		boolean isOffGrid = (pos.x > grid_rows - 1) | (pos.y > grid_cols - 1) | offgrid.contains(pos);
		
		if (isAtDest) return true;
		else if (isOffGrid)
		{
//			System.out.println("Off_Grid " + pos);
			moves.remove(moves.size()-1);
			return false;
		}
//		System.out.println("MOVE " + pos);
		if (moveNext(new Point(pos.x +1, pos.y), dest, offgrid)) return true;
		else if (moveNext(new Point(pos.x, pos.y + 1), dest, offgrid)) return true;
		else
		{
//			System.out.println("BLOCK " + pos.toString());
			offgrid.add(pos);
			moves.remove(moves.size()-1);
			return false;
		}
	}
}
