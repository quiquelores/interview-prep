
public class TwoDArraySearcher {

	/**
	 * Given an ordered 2-D array, where every element is greater than the element in the row above it or the column to its left, 
	 * write a contains method.
	 */
	public static 
	int[][] array = new int[10][10];
	static int count = 0;


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for(int i = 0; i< array.length; i++){
			for(int j = 0; j<array.length; j++){
				System.out.print("[" + (i+1)*(j+1)+"]");
				array[i][j] = (i+1)*(j+1);
			}
			System.out.println();
		}
		//System.out.println(contains(1));
		//System.out.println(contains(2));
		//System.out.println(contains(27));
		System.out.println(contains(10));

		/*
		 * 1 2 3 
		 * 4 8 7
		 * 5 9 11
		 * 
		 */
	}
	public static boolean contains(int i){
		return containsRec(i, 0, array.length, 0, array[0].length);
	}
	public static boolean containsRec(int query, int xLow, int xHigh, int yLow, int yHigh){
		if(count>50){
			return false;
		}
		count ++;
		int xMid = (xLow+xHigh)/2;
		int yMid = (yLow + yHigh)/2;
		//System.out.println(query+ " " + xLow + " " + xHigh + " " + yLow + " " + yHigh + " " + array[xMid][yMid]);

		if(array[xMid][yMid] == query){
			return true;
		}
		else if(xLow == xHigh && yLow == yHigh){
			return false;
		}
		else if(array[xMid][yMid] > query){
			boolean ret1 = (xLow != xHigh) ? containsRec(query, xLow, xHigh, yLow, yMid) : false;
			boolean ret2 = (yLow != yHigh) ? containsRec(query, xLow, xMid, yLow, yHigh) : false;
			return ret1 || ret2;
		}
		else if(array[xMid][yMid] < query){
			boolean ret1 = (xLow != xHigh) ? containsRec(query, xMid, xHigh, yLow, yMid) : false;
			boolean ret2 = (yLow != yHigh) ? containsRec(query, xLow, xHigh, yMid, yHigh) : false;
			return ret1 || ret2;
		}
		return false;
	}

}
