
public class BinarySearch {

	/**
	 * Given a phonebook and a phone number N, search whether N is in the phonebook. Return its position or -1 if N isn't in the list.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1, 3, 5, 6, 7, 9 , 11 , 12 , 13, 14 };
		PhoneBook pb = new PhoneBook(a);
		int eleven = pb.findNum(11);
		int eight = pb.findNum(8);
		System.out.print(eleven + "" +  eight);
	}
	public static class PhoneBook {
		int[] list = new int[10];
		public PhoneBook(int[] a){
			this.list = a;
		}
		public int findNum(int x){
			//if found return index
			//if not found return -1
			//corner cases:
			if(this.list.length == 0){
				return -1;
			}
			return findNumRec(x, 0, list.length-1);
		}
		public int findNumRec(int x, int i, int j){
			int mid = (i + j)/2;
			if(i>j){
				return -1;
			}
			else if(this.list[mid]== x){
				return mid;
			}
			else if(this.list[mid] < x){
				return findNumRec(x, mid+1, j);
			}
			else if(this.list[mid] > x){
				return findNumRec(x, i, mid -1);
			}
			return -1;
		}
		
	}

}
