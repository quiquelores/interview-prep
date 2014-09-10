


public class LinkedListReverser {

	/**
	 * Given a LinkedList, reverse it.
	 * INPUT: A -> B -> C -> D
	 * OUTPUT: D -> C -> B -> A
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node D = new Node("D", null);
		Node C = new Node("C", D);
		Node B = new Node("B", C);
		Node A = new Node("A", B);
		
		LinkedList list = new LinkedList(A, D);
		Node printAux = new Node("Before: ", list.first);
		while(printAux != null){
			System.out.println(printAux.data);
			printAux = printAux.next;
		}
		
		list.reverseList();
		
		Node printAux2 = new Node("After: ", list.first);
		while(printAux2 != null){
			System.out.println(printAux2.data);
			printAux2 = printAux2.next;
		}
	}	
	public static class Node{
		public String data = "";
		public Node next = null;
		
		public Node(String s, Node n){
			this.data = s;
			this.next = n;
		}
	}
	public static class LinkedList{
		public Node first = null;
		public Node last = null;
		
		public LinkedList (Node f, Node l){
			this.first = f;
			this.last = l;
		}	
		public void reverseList(){
			LinkedList result = new LinkedList(null, null);
			result.last = this.first;
			Node aux = this.first;
			while(aux!=null){
				this.first = aux.next;
				aux.next = result.first;
				result.first = aux;
				aux = this.first;
			}
			this.first = result.first;
			this.last = result.last;
		}
	}
}