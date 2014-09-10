
public class SubsetFinder {

	/**
	 * Given an array of integers, find all possible subsets in that array.
	 * Example: {1,2,3} --> {}, {1},{2},{3},{1,2},{1,3},{2,3},{1,2,3}
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1,2,3,4,5,6,7};
		String[] subsets = findAllSubsets(array);
		for(int i = 0; i < subsets.length; i++){
			System.out.println(subsets[i]);
		}
	}
	public static String[] findAllSubsets(int[] set){
		String[] sbs = {""};
		return findRecurs(set, sbs,0);
	}
	public static String[] findRecurs(int[] set, String[] subsets, int index){
		if(index == set.length){
			return subsets;
		}
		String [] newSubsets = new String[subsets.length * 2];
		int i = 0;
		while(i<subsets.length){
			newSubsets[i] = subsets[i];
			i++;
		}
		for(int j = 0; j < subsets.length; j++){
			newSubsets[i+j] = subsets[j] + set[index]; 
		}
		return findRecurs(set, newSubsets, index+1);
	}
	

}
