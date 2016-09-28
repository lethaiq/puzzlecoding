import java.util.ArrayList;

public class RobotGrid {
	final static int grid_rows = 8;
	final static int grid_cols = 8;
	static ArrayList<String> moves = new ArrayList<String>();
	public enum Move {RIGHT, DOWN, STOP, STUCK};
	
	public static void main(String[] args)
	{
		Position origin = new Position(0, 0);
		Position destination = new Position(7,7);
		
		int[][] obstacle = new int[grid_rows][grid_cols];
		obstacle[1][0] = -1;
		obstacle[2][1] = -1;
		obstacle[3][2] = -1;
		obstacle[2][3] = -1;
		obstacle[2][3] = -1;
		obstacle[1][3] = -1;
		moveNext(origin, destination, obstacle);
		System.out.println(moves);
	}
	
	public static boolean moveNext(Position pos, Position dest, int[][] obstacle)
	{
		if(pos.left == dest.left && pos.top == dest.top)
		{
			System.out.println("END " + pos);
			return true;
		}
		else if(pos.left > grid_rows - 1 | pos.top > grid_cols - 1)
		{
			System.out.println("OFF-GRID " + pos);
			moves.remove(moves.size()-1);
			return false;
		}
		else if (obstacle[pos.left][pos.top] == -1)
		{
			System.out.println("OBSTACLE " + pos);
			moves.remove(moves.size()-1);
			return false;
		}
		
		if (moveNext(pos.move(Move.RIGHT), dest, obstacle)) return true;
		else if (moveNext(pos.move(Move.DOWN), dest, obstacle)) return true;
		else
		{
			System.out.println("BLOCK " + pos.toString());
			obstacle[pos.left][pos.top] = -1;
			moves.remove(moves.size()-1);
			return false;
		}
	}
	
	static class Position
	{
		private int left;
		private int top;
		public Position(int _left, int _top)
		{
			this.left = _left;
			this.top = _top;
		}
		public Position()
		{
			this.left = 0;
			this.top = 0;
		}
		public String toString(){
			return left + "-" + top;
		}
		public Position move(Move _direction)
		{
			
			Position newPosition;
			if(_direction.equals(Move.DOWN)) newPosition = new Position(this.left, this.top + 1);
			else newPosition = new Position(this.left+1, this.top);
			System.out.println("MOVE " + newPosition);
			moves.add(newPosition.toString());
			return newPosition;
		}
	}
	
}
