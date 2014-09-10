
public class findAllPermutations {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String abcd = "abcd";
		String[] perm = findPermutations(abcd);
		for(int i = 0; i<perm.length; i++){
			System.out.println(perm[i]);
		}
	}
	public static String[] findPermutations(String str){
		String[] perm = new String[1];
		
		perm[0] = str.substring(0, 1);
		return findRecurs(perm, str, 1);
	}
	public static String[] findRecurs(String[] perm, String str, int index){
		//System.out.println(index + "Current perm");
		for(int i = 0; i<perm.length; i++){
			//System.out.println(perm[i]);
		}
		if(index == str.length()){
			return perm;
		}
		
		String charToAdd = str.substring(index,index+1);
		System.out.println(charToAdd);
		String[] newPerm = new String[perm.length*(index+1)];
		for(int i = 0; i< perm.length; i++){
			for(int j = 0; j< index+1; j++){
				if(perm[i] != null){
					newPerm[i+j] ="";
					if(j<=perm[i].length()){
						
						//System.out.println("CCC" + perm[i].substring(0,j));
						newPerm[i+j] += perm[i].substring(0,j);
					}
					newPerm[i+j] += charToAdd;
					if(j<=perm[i].length()){
						newPerm[i+j]+= perm[i].substring(j); 
					}
				}
			}
		}
		return findRecurs(newPerm, str, index+1);
	

	}
	
}
