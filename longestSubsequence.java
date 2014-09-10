
public class longestSubsequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 1, 2, 3, 1, 2, 3, 4, 5, 1, 2, 1, 2, 3};
		int[] b = longestSubsequence(a);
		for(int i = 0; i < b.length; i++){
			System.out.println(b[i]);
		}
	}
	public static int[] longestSubsequence(int[] a){
		int currLeft = 0;
		int currRight = 0;
		int maxLeft = 0;
		int maxRight = 0;
		
		for(int i =0 ; i < a.length; i++){
			if(i-1> 0 && a[i-1] < a[i]){
				currRight++;
					if(currRight-currLeft > maxRight - maxLeft){
						maxRight = currRight;
						maxLeft = currLeft;
					}
			}
			else{
				currLeft = i;
				currRight = i;
			}
		}
		int[] res = new int[maxRight-maxLeft +1];
		for(int j = 0; j < res.length; j++){
			res[j] = a[maxLeft+j];
		}
		return res;
	}

}
