
public class HeapSort {

	/**
	 * @param args
	 */
	int[] heap = new int[20];
	int last = -1;
	public HeapSort(){
		
	}
	
	public static void main(String[] args) {

		HeapSort h = new HeapSort();
		while(h.last < 9){
			h.add(++h.last);
		}
		for(int i = 0; i< h.last; i++){
			System.out.println(h.heap[i]);
		}
		


	}
	public int leftChild(int parent){
		return 2*parent +1;
	}
	public int rightChild(int parent){
		return 2*parent +2;
	}
	public int parent(int child){
		return (child-1)/2;
	}
	public void add(int n){
		this.heap[this.last] = n;
		this.upHeap(n);
		
	}
	
	public void upHeap(int n){
		if(parent(n)> -1 && this.heap[parent(n)] < this.heap[n]){
			swap(n, parent(n));
			upHeap(parent(n));
		}
	}
	public void downHeap(int n){
		if(rightChild(n) <= this.last && this.heap[rightChild(n)] > this.heap[n]){
			swap(n, rightChild(n));
			downHeap(rightChild(n));
		}
		else if(leftChild(n) <= this.last && this.heap[leftChild(n)] > this.heap[n]){
			swap(n, leftChild(n));
			downHeap(leftChild(n));
		}			
	}
	public void swap(int i, int j){
		int temp = this.heap[i];
		this.heap[i] = this.heap[j];
		this.heap[j] = temp;
	}
	
	

}
