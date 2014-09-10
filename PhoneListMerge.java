import java.util.HashSet;


public class PhoneListMerge {

	/**
	 * Given two lists of numbers, merge them. A Phone number can be marked as deleted. The merged list shall only contain non-deleted Phone numbers and no duplicates.
	 * If a Phone number is in both lists, and marked as deleted in one of them, it should not be in the merged list.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Phone[] list = new Phone[5];
		Phone[] list2 = new Phone[4];
			
		list[0] = new Phone(1, true);
		list[1] = new Phone(12, false);
		list[2] = new Phone(123, false);
		list[3] = new Phone(1234, false);
		list[4] = new Phone(12345, false);

		list2[0] = new Phone(0, true);
		list2[1] = new Phone(1, false);
		list2[2] = new Phone(12, false);
		list2[3] = new Phone(1234, true);
		
		HashSet hs = new HashSet();
		
		//go through lists. 
			//if deleted
				//add deleted to hash
		for(int i = 0; i < list.length; i++){
			if(list[i].isDeleted()){
				hs.add(list[i].number);
			}
		}
		for(int j = 0; j < list2.length; j++){
			if(list2[j].isDeleted()){
				hs.add(list2[j].number);
			}
		}

		//go through lists 
			//if not in deleted hash and not added hash
				//add to list
				//add to added hash
		Phone[] listRes = new Phone[list.length + list2.length];
		int lastObj = 0;
		for(int i = 0; i < list.length; i++){
			if(!hs.contains(list[i].number)){
				listRes[lastObj] = list[i];
				hs.add(list[i].number);
				lastObj++;
			}
		}
		for(int i = 0; i < list2.length; i++){
			if(!hs.contains(list2[i].number)){
				listRes[lastObj] = list2[i];
				hs.add(list[i].number);
				lastObj++;
			}
		}
		
		for(int i = 0; i < listRes.length; i++){
			if(listRes[i] != null){
			System.out.println(listRes[i].number);
			}
		}

		
	}
	
	public static class Phone{
		public int number = 0;
		public boolean deleted = false;
		
		public Phone(int n, boolean d){
			this.number = n;
			this.deleted = d;
		}
		
		public boolean isDeleted(){
			return this.deleted;
		}
	}

}
