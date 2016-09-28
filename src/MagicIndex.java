import java.util.Arrays;
import java.util.HashSet;

/**
 * Problem Statement (Problem 8.4 Cracking The Coding Interview 6th ed.
 * 
 * @author lethai
 *
 */
public class MagicIndex {
	private static HashSet<Integer> magic = new HashSet<Integer>();
	
	public static void main(String[] args)
	{
		int[] arr = {1, 2, 4, 5, 19, 20, 0, 10, 9};
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		getMagicIndex(arr, 0, arr.length - 1);
		for (int i:magic) System.out.println(i);
		
	}
	
	private static void getMagicIndex(int[] arr, int from, int to)
	{	
		if (to < from | from < 0 | from > arr.length - 1 | to < 0 | to > arr.length - 1){
			return;
		}
		int mid = from + (to - from) / 2;
//		System.out.println("checking index " + mid + " from " + from + " to " + to);
		if (arr[mid] == mid)
		{
			magic.add(mid);
			getMagicIndex(arr, mid + 1, to);
			getMagicIndex(arr, from, mid - 1);
		}
		else if (arr[mid] > mid) getMagicIndex(arr, from, mid - 1);
		else if (arr[mid] < mid) getMagicIndex(arr, mid + 1, to);
	}
}
