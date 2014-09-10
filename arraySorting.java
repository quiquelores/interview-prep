
public class ArraySorting {

	/**
	 * Array sorting algorithms
	 */
	
	  private static final int SIZE = 50;
	  private static final int DIGITS = 3;
	  private static final int MAX_VALUE = (int)Math.pow(10,DIGITS)-1;
	  private static final int NUM_PER_LINE = 10;
	  private static int[] values = new int[SIZE];
	  private static int numSwaps = 0;

	  private static void initValues() {
	    for (int i=0; i<SIZE; i++)
	      values[i] = (int)((MAX_VALUE+1)*Math.random());
	  }

	  private static boolean isSorted() {
	    for (int i=0; i<SIZE-1; i++)
	      if (values[i] > values[i+1])
	    	  return false;
	    return true;
	  }

	  //Swaps are only be performed only during insertion sort.
	  private static void swap (int i, int j) {
	    int t = values[i];
	    values[i] = values[j];
	    values[j] = t;
	    numSwaps++;
	  }

	  private static void printValues() {
	    System.out.println("The value array is:");
	    for (int i=0; i<SIZE; i++)
	      if ((i+1) % NUM_PER_LINE == 0)
	    System.out.printf("%4d\n", values[i]);
	      else
	    System.out.printf("%4d"  , values[i]);
	    System.out.println();
	  }
	public static void main(String[] args) {
		initValues();
	    printValues();
	    System.out.printf("The array %s initially sorted.",
	              isSorted() ? "is" : "is not");
	    sortValues();
	    printValues();
	    System.out.printf("After performing %d swaps,\n", numSwaps);
	    System.out.printf("the array is %s sorted.",
	                      isSorted() ? "now" : "still not");
	                      
	  }

	  private static void sortValues() {
		  // call sort program here

		  //insertionSort();
		  mergeSort(0, SIZE-1);
	  }
	  private static void insertionSort(){
		  for(int i = 0; i< SIZE; i++){		 
			  int j = i;
			  while(j>0 && values[j] < values[j-1] ){
				  swap(j, j-1);
				  j--;
			  }
		  }
	  }
	  /*
	   * 3, 5, 1, 4
	   * mergesort() first half, second half
	   * 3 , 5 -- 1,4
	   * mergesort() first half, second half
	   * 3 -- 5 -- 1 -- 4
	   */
	  private static void mergeSort(int first, int last){
		  if(first < last){
			  int mid = (first + last)/2;
			  mergeSort(first, mid);
			  mergeSort(mid+1, last);
			  merge(first, mid, last);
		  }
	  }
	  private static void merge(int first, int mid, int last){
		  int[] temp = new int[last-first+1];
		  int indexFirst = first;
		  int indexLast = mid+1;
		  int i = 0;
		  while(indexFirst <= mid && indexLast <= last){
			  if(values[indexFirst] < values[indexLast]){
				  temp[i++] = values[indexFirst++];
			  }
			  else {
				  temp[i++] = values[indexLast++];
				  }
		  }
		while(indexFirst<=mid){
			temp[i++] = values[indexFirst++];
		}
		while(indexLast<=last){
			temp[i++] = values[indexLast++];
		}
		  for(int j = 0; j< temp.length;j++){
			  values[first+j] = temp[j];
		  }
		  
	  }

}
