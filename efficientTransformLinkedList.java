
public class EfficientTransformLinkedList {

	/**
	 * Given a linked list transform it such that the last element becomes the second element, the second to last becomes the fourth element, 
	 * third to last sixth,etc.
	 * Example: A -> B -> C -> D  ---> A -> D -> B -> C
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
				
		Node D = new Node("D", null);
		Node C = new Node("C", D);
		Node B = new Node("B", C);
		Node A = new Node("A", B);
		
		LinkedList list = new LinkedList(A, D);
				
		Node printAux1 = new Node("Before: ", list.first);
		int length = 0;
		while(printAux1 != null){
			length ++;
			System.out.println(printAux1.data);
			printAux1 = printAux1.next;
		}
		length--;
		System.out.println(length);
		//split lists into list1 and list2
		LinkedList l1 = new LinkedList(null, null);
		l1.first = list.first;
		l1.last = list.first;
		for(int i = 0; i < length /2; i++){
			l1.addToEnd(list.popFirst());
		}
		list.reverseList();
		
		LinkedList l3 = new LinkedList(null, null);
		l3.first = l1.first;
		l3.last = l3.first;
		while(l1.first != null || list.first !=null){
			l3.addToEnd(l1.popFirst());
			l3.addToEnd(list.popFirst());
		}
		Node printAux2 = new Node("After: ", l3.first);
		while(printAux2 != null){
			System.out.println(printAux2.data);
			printAux2 = printAux2.next;
		}
		
	}
	
	public static class Node{
		public String data = "";
		public Node next = null;
		
		public Node(String data, Node next){
			this.data = data;
			this.next = next;
		}
	}
	public static class LinkedList{
		public Node first = null;
		public Node last = null;
		
		public LinkedList(Node first, Node last){
			this.first = first;
			this.last = last;
		}
		
		public void addToBeginning(Node n){
			n.next = this.first;
			this.first = n;
		}
		public void addToEnd(Node n){
			this.last.next = n;
			this.last = n;
			n.next = null;
		}
		public Node popFirst(){
			Node n = this.first;
			if(n==null){
				return null;
			}
			this.first = n.next;
			return n;
		}
		public void reverseList(){
			LinkedList revList = new LinkedList(null,null);
			
			while(this.first!= null){
				revList.addToBeginning(this.popFirst());
			}
			this.first = revList.first;
			this.last = revList.last;
		}
	}
}
