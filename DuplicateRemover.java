import java.util.HashSet;


public class DuplicateRemover {

	/**
	 * Given a String, remove all duplicates of every character, only leaving the first occurrence. 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "ABRAACADABRALOREAMIPSAUA";
		System.out.println(str);
		String rem = removeDuplicates(str);
		System.out.println(rem);
	}
	public static String removeDuplicates(String str){
		HashSet<Character> hs = new HashSet<Character>();
		int i = 0;
		while(i < str.length()){
			if(hs.contains(str.charAt(i))){
				str = str.substring(0, i) + str.substring(i+1);				
			}
			else{
			hs.add(str.charAt(i));
			i++;
			}	
		}
		return str;
	}
}
