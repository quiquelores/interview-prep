
public class binarySearchTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//add elements to Tree
		Node n = new Node(6);
		BSTree bst = new BSTree();
		bst.head = n;
		bst.addToTree(5);
		bst.addToTree(3);
		bst.addToTree(8);
		bst.addToTree(9);
		bst.addToTree(1);
		bst.addToTree(4);
		
		
		int[] array = {1,2,3,4,5,6,7,8,9};
		BSTree perfectTree = new BSTree();
		perfectTree.createPerfectTreeFromArray(array, 0, array.length-1);
		
		perfectTree.traversePostOrder(perfectTree.head);
		System.out.println();

		perfectTree.traversePreOrder(perfectTree.head);
		System.out.println();

		perfectTree.traverseInOrder(perfectTree.head);
		perfectTree.remove(perfectTree.head);
		System.out.println();

		perfectTree.traverseInOrder(perfectTree.head);

	/*	1 2 3 4 5 6 7 8 9
	 
				5
			2		7
		1		3	6	8
		 		  4			9
		PRE: 52137689
		POST:  					
	*/	
			
	/*	
				6
			5		8
		3				9
	1	 	4
	*/	
		
	/*	
				5
			2				7
		1 		3		6		8
	*/	
		
		Node one = new Node(1);
		Node three = new Node(3);
		Node two = new Node(2, one, three);
		Node six = new Node(6);
		Node eight = new Node(8);
		Node seven = new Node(7, six, eight);
		Node five = new Node(5, two, seven);
		System.out.println(BSTree.isBST(five));
		
		/*System.out.println("IN");
		bst.traverseInOrder(bst.head);
		System.out.println();
		System.out.println("PRE");
		bst.traversePreOrder(bst.head);
		System.out.println();
		System.out.println("POST");
		bst.traversePostOrder(bst.head);*/


	}
	
	public static class BSTree{
		public Node head;
		public String name;
		
		public BSTree(){
		}
		
		public void addToTree(int d){
			if(this.head == null){
				this.head = new Node(d);
				return;
			}
			
			Node aux = this.head;

			while(aux != null){
				if(aux.data < d){
					if(aux.right == null){
						aux.right = new Node(d);
						return;
					}
					aux = aux.right;
				}
				else if(aux.data >= d){
					if(aux.left == null){
						aux.left = new Node(d);
						return;
					}
					aux = aux.left;
				}
			}
		}
		public void remove(Node n){
			System.out.println("Removing Node" + n.data);
			if(n.left == null && n.right == null){
				Node parent = this.findParent(n);
				if(parent.right == n){
					parent.right = null;
				}
				else if(parent.left == n){
					parent.left = null;
				}
			}
			if(n.left != null){
				
				Node aux = n.left;
				while(aux.right != null){
					aux = aux.right;
				}
				int data = aux.data;
				remove(aux);	

				n.data = data;
			}
			int data = n.data;
			n = n.right;
		}
		
		//traversals
		public void traverseInOrder(Node aux){
			//Node aux = this.head;
			if(aux != null){
				
				if (aux.left!= null){
					traverseInOrder(aux.left);
				}
				
				visit(aux);
				
				if(aux.right != null){
					traverseInOrder(aux.right);
				}
			}
			//if there's a child, visit child. then visit itself. then visit right.
			
		}
		public void traversePostOrder(Node aux){
				if(aux != null){
				
					traversePostOrder(aux.left);
					traversePostOrder(aux.right);
				
					visit(aux);
				}
		}
		public void traversePreOrder(Node aux){
			if(aux != null){
				visit(aux);
				traversePreOrder(aux.left);
				traversePreOrder(aux.right);
			}
		}
		public void  visit(Node n){
			System.out.print(n.data);
		}
		public void createPerfectTreeFromArray(int[] a, int i, int j){
			if(i>j){
				return;
			}
			int mid = (i+j)/2;
			this.addToTree(a[mid]);
			createPerfectTreeFromArray(a, mid+1, j);
			createPerfectTreeFromArray(a, i, mid-1);

		}
		public Node findParent(Node n){
			System.out.println("Finding parent of" + n.data);
			Node aux = this.head;
			System.out.println(this.head.left);
			
			while(n != aux.right){
				if(n.data <= aux.data ){
					aux = aux.left;
				}
				else if(n.data > aux.data){
					aux = aux.right;
				}
			}
			return aux;
		}
		public static boolean isBST(Node n){
			if(n == null){
				return true;
			}
			else if(n.left != null && n.left.data > n.data || n.right != null && n.right.data < n.data){
				return false;
			}
			return isBST(n.left) || isBST(n.right);
		}
	}
	public static class Node{
		public int data;
		public Node left;
		public Node right;
		
		public Node(){
			this.left = null;
			this.right = null;
		}
		
		public Node(int d){
			this.data = d;
			this.left = null;
			this.right = null;
		}
		public Node(int d, Node l, Node r){
			this.data = d;
			this.left = l;
			this.right = r;
		}
		public void setData(int i){
			this.data = i;
		}
	}

}
