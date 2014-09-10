
public class findDeepestNode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		Node aa = new Node("A");
		Node b = new Node("B");
		Node c = new Node("C");
		Node d = new Node("D");
		Node e = new Node("E");
		Node f = new Node("F");
		Node g = new Node("G");
		Tree t = new Tree(aa);
		aa.setLeft(b);
		b.setLeft(c);
		c.setRight(d);
		d.setLeft(e);
		e.setLeft(f);
		c.setLeft(g);
		
		Node deepest = t.findDeepest();
		System.out.println(deepest.height);
		System.out.println(deepest.name);

	}
	
	public static class Tree{
		Node head;
		Node highest;
		public Tree(){
		}
		public Tree(Node h){
			head = h;
			head.height = 0;
		}
		public Node findDeepest(){
			Node aux = this.head;
			if(this.head == null){
				return null;
			}
			visit(aux);
			return this.highest;
		}
		public void visit(Node n){
			if(n.right == null && n.left == null && (this.highest == null || n.height > this.highest.height)){
				this.highest = n;
			}
			if(n.left != null){
				visit(n.left);
			}
			if(n.right != null){
				visit(n.right);
			}
		}
	}
	public static class Node{
		Node left;
		Node right;
		String name;
		int height;
		
		public Node(String n){
			this.name = n;
		}
		public Node(Node l, Node r, String n){
			left = l;
			right = r;
			name = n;
		}
		public void setLeft(Node n){
			this.left = n;
			this.left.height = this.height+1;
		}
		public void setRight(Node n){
			this.right = n;
			this.right.height = this.height+1;
		}
	}
	

}
