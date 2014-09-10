
public class LinkedListTransformer {

	/**
	 * Given a linked list, transform it such that the order is as follows: 1st element, last element, 2nd element, 2nd to last, 3rd element, 3rd to last, ...
	 * Example: A -> B -> C -> D  ---> A-> D -> B -> C
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
				
		Node D = new Node("D", null);
		Node C = new Node("C", D);
		Node B = new Node("B", C);
		Node A = new Node("A", B);
		Node Z = new Node("Z", A);
		Node Y = new Node("Y", Z);
	
		LinkedList list = new LinkedList(Y, D);
		
		LinkedList resList = new LinkedList(null, null);
		
		Node printAux1 = new Node("Before: ", list.first);
		while(printAux1 != null){
			System.out.println(printAux1.data);
			printAux1 = printAux1.next;
		}
		
		resList.first = list.first;
		resList.last = list.first;
		list.first = list.first.next;
		
		//O(N^2) approach
		
		while(list.first != null && list.last !=null){
				resList.last.next = list.last;
				resList.last = resList.last.next;
				
				Node aux = new Node("Aux", list.first);
				while(aux.next.next != null){
					aux = aux.next;
				}
				list.last = aux;
				aux.next = null;
			
			resList.last.next = list.first;
			resList.last = resList.last.next;
			list.first = list.first.next;
		}
		list = resList;
		
		Node printAux2 = new Node("After: ", list.first);
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
	}
	

}
