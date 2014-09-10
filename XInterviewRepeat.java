import java.util.Set;


public class XInterviewRepeat {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] str = {"red", "blue", "yellow"};
		int[] ints = {3, 2, 1};
		RandomValue rv = new RandomValue(str, ints);
		System.out.println(rv.getRandom());
		System.out.println(rv.getRandom());

		System.out.println(rv.getRandom());

		System.out.println(rv.getRandom());

		System.out.println(rv.getRandom());

		System.out.println(rv.getRandom());

	}
}

class RemoveDupl{
	public Set[] removeDuplicates(Set<String>[] s){
		for(int i = 0; i < s.length; i++ ){
			// TODO
		}
		return null;
	}
}

class RandomValue {
	String[] values;
	
	public RandomValue(String[] val, int[] prob){
		int sum = 0;
		for(int i = 0; i < prob.length; i++){
			sum+=prob[i];
		}
		this.values = new String[sum];
		int currIndex = 0;
		for(int j = 0; j < prob.length; j++){
			for(int k = 0; k < prob[j]; k++){
				values[currIndex++] = val[j];
			}
		}
	}
	public String getRandom(){
		return values[(int) (Math.random()*(values.length))];
	}
}