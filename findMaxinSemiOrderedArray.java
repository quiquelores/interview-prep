
public class findMaxinSemiOrderedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] array = new int[12
		                      ];
		array[0] = 100;
		array[1] = 47;
		array[2] = 46;
		array[3] = 45;
		array[4] = 44;
		array[5] = 43;
		array[6] = 6;
		array[7] = 5;
		array[8] = 5;
		array[9] = 2;
		array[10] = 101;
		array[11] = 5;

		System.out.print(findMax(array));
		
	}
	public static int findMax(int[] a){
		return a[recursFindMax(a, 0, a.length)];
	}

	public static int recursFindMax(int[] a, int i, int j){
		int mid = (i + j)/2;
		if(mid == 0 || (mid == a.length-1)|| (a[mid-1]<a[mid] && a[mid+1]<a[mid])){
			System.out.println('1');
			return mid;
		}
		else if(a[mid-1]>a[mid]){
			System.out.println('2');

			return recursFindMax(a, i, mid);
		}
		else if(a[mid+1]>a[mid]){
			System.out.println('3');

			return recursFindMax(a, mid, j);
		}
		return -1;

	}

}
