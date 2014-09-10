
public class arrayPractice {

	/**
	 * You are given an array [a1 To an] and we have to construct another array [b1 To bn] where bi = a1*a2*É*an/ai. 
	 * You are allowed to use only constant space and the time complexity is O(n). No divisions are allowed.
	 */
	public static int[] c = new int[100];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
		int[] b = getTransformedArray(array);
		for(int i = 0; i < array.length; i++){
			System.out.println(array[i] + " " + b[i] + " " + c[i]);
		}
	}
	
	public static int[] getTransformedArray(int[] a){
		int mult = 1;
		for(int i = 0; i<a.length; i++){
			mult*=a[i];
		}
		int[] b = new int[a.length];
		for(int j = 0; j<b.length; j++){
			b[j] = divide(mult, a[j]);
			c[j] = mult / a[j];
		}
		return b;
	}
	public static int divide(int numerator, int denominator){
		int result = 0;
		while(numerator - denominator > -1){
			result++;
			numerator -=denominator;
		}
		return result;
	}
}
