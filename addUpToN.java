
public class addUpToN {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] array = {1,2,3,4,5,6};
		int[] sums = {1, 3, 11, 12, 24};
		for(int a = 0; a < sums.length; a++){
			System.out.println(sums[a] +" " + addUpTo(array, sums[a]));
		}
	}
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

}
