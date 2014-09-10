
public class heap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HeapNode head = new HeapNode();
		head.data = 10;
		head.add(3);
		head.add(2);
		head.add(12);
		head.add(7);
	}
	
	public static class HeapNode{
		
		int data;
		HeapNode right;
		HeapNode left;
		public HeapNode(int data, HeapNode right, HeapNode left){
			this.data = data;
			this.right = right;
			this.left = left;
		}
		public HeapNode(int data){
			this.data = data;
		}
		public HeapNode(){
		}
		public add(int x){
			
		}
	}

}
