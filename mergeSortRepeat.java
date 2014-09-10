
public class mergeSortRepeat {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int mergesort(int i, int j){
		int mid = (i+j)/2;
		if(j-i > 1){
			return mergesort(i, mid) + mergesort(mid, j);
		}
		return merge(i,j);
	}
	
	public int merge(int i, int j){
		for()
	}
	// mergesort
		//split into halves until they're of size 1, then merge
	
	//merge

}
