
public class LongestStreakInArrayFinder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1, 1, 1, 2, 2, 3, 3, 3, 3, 4, 5, 6 ,7, 8, 8, 8, 8, 8, 8, 9};
		int[] a2 = {0,0,0,0,0,1,1,1,1};
	
		System.out.println(findLongestStreak(array, 9));
	}
	
	public static int  findLongestStreak(int[] a, int x){
		if(a[0] > x || a[a.length-1] < x){
			return 0;
		}
		return findRecursively(a, x, 0, a.length-1);
	}

	public static int findRecursively(int[] a, int x, int i, int j){
		int mid = (i + j)/2;
		
		if(i > j){
			return 0;
		}
		else if(a[i] ==  x && x == a[j]){
			return (j-i+1);
		}
		else if(a[mid]<x){
			return findRecursively(a, x, mid+1, j);
		}
		else if(a[mid]>x){
			return findRecursively(a, x, i, mid-1);
		}
		else if(a[mid] == x){
			return findRecursively(a, x, i, mid-1) + 1 + findRecursively(a, x, mid+1, j);
		}
		return -1;
	}
}
