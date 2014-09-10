
public class BinarySearchRepeat {

	/**
	 * Recursive and non-recursive binary search algorithms.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
		int[] b = {0, 3, 4, 5, 9, 10, 15, 23, 39};
		System.out.println(binarySearchNonRec(a, 10));
		System.out.println(binarySearchNonRec(b, 10));
		System.out.println(binarySearchNonRec(b, 1));

		System.out.println(binarySearchRecCaller(a, 10));
		System.out.println(binarySearchRecCaller(b, 10));
		System.out.println(binarySearchRecCaller(b, 1));
	}
	public static int binarySearchNonRec(int[] array, int query){
		int i = 0;
		int j = array.length -1;
		int mid;
		int a = 0;
		while(i<j && a < 10){
			a++;
			mid = (j+i)/2;			
			if(array[mid] == query){
				return mid;
			}
			else if(array[mid] < query && array[j] >= query){
				i = mid;
			}
			else if(array[mid] > query && array[i] <= query){
				j = mid;
			}
		}
		return -1;
	}
	public static int binarySearchRecCaller(int[] array, int query){
		return binarySearchRecCallee(array, query, 0, array.length-1);
	}
	public static int binarySearchRecCallee(int[]array, int query, int low, int high){
		int mid = (high+low)/2; 
		if(array[mid] == query){
			return mid;
		}
		else if(array[low] > query || array[high] < query || low > high){
			return -1;
		}
		else if(array[mid]<query && mid != low){
			return binarySearchRecCallee(array, query, mid, high);
		}
		else if(array[mid]>query){
			return binarySearchRecCallee(array, query, low, mid);
		}
		return -1;
	}
	

}
