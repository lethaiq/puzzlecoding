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
//		int[] arr = {1, 2, 4, 4, 5, 5, 0, 10, 11, 11, 8, 8};
		int[] arr = {-10, -5, 2, 2, 2, 3, 4, 7, 9, 12, 13};
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		getMagicIndex(arr, 0, arr.length - 1);
		for (int i:magic) System.out.println(i);
		
	}
	
	private static void getMagicIndex(int[] arr, int from, int to)
	{	
		if (to < from | from < 0 | from > arr.length - 1 | to < 0 | to > arr.length - 1) return;
		int mid = from + (to - from) / 2;
//		System.out.println("checking index " + mid + " from " + from + " to " + to);
		if (arr[mid] == mid)
		{
			magic.add(mid);
			getMagicIndex(arr, mid + 1, to);
			getMagicIndex(arr, from, mid - 1);
		}
		else if (arr[mid] > mid)
		{
			int diff = arr[mid] - mid;
			if ((to - mid) >= diff) getMagicIndex(arr, mid + diff, to);
			getMagicIndex(arr, from, mid - 1);
		}
		else if (arr[mid] < mid) 
		{
			int diff = mid - arr[mid];
			if ((mid - from) >= diff) getMagicIndex(arr, from, mid - diff);
			getMagicIndex(arr, mid + 1, to);
		}
	}
}
