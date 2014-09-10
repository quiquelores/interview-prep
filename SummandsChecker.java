import java.util.HashSet;


public class SummandsChecker {

	/**
	 * Check whether an array contains to integers that add up to N.
	 * Example:
	 * 	Input: integer N such that N = x + y, array {...,x,...,y}
	 * 	Output: true
	 */
	
	public static void main(String[] args) {	
		int[] array = {1,2,3,4,5,6};
		int[] sums = {1, 3, 11, 12, 24};
		for(int a = 0; a < sums.length; a++){
			System.out.println(sums[a] +" Inefficient method:" + addUpTo(array, sums[a]) + " Efficient Method:" + addUpToFast(array, sums[a]));
		}
	}
	//O(n^2) approach
	public static boolean addUpTo(int[] array, int n){
		for(int i = 0; i < array.length; i++){
			for(int j = 0; j<array.length; j++){
				if(i!= j && array[i] + array[j] == n){
					return true;
				}
			}
		}
		return false;
	}
	//O(n) approach using HashSet
	public static boolean addUpToFast(int[] array, int n){
		HashSet<Integer> hs = new HashSet<Integer>();
		for(int i = 0; i < array.length; i++){
			if(hs.contains(n-array[i]))
				return true;
			hs.add(array[i]);
		}
		return false;
	}
}
