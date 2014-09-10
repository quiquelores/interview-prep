
public class StringSum {

	/**
	 * Given 2 Strings of numbers, return the sum in a String.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(sum("11111111111111111111111111111111111111111111111111111111111222222222222222999999111111111111119111", "191"));
	}
	public static String sum(String s1, String s2){
		//start at end of both strings
			// sum last chars, > 10 then carry 1, add mod 10 at beginning of result
		int index1 = s1.length();
		int index2 = s2.length();
		int carry = 0;
		String result = "";
		
		while(index1 > 0 && index2 > 0){
			int num1 = (int) s1.charAt(--index1) - '0';
			int num2 = (int) s2.charAt(--index2) - '0';
			//index2--;
			int sum = num1 + num2 + carry;
			carry = 0;
			if(sum>=10){
				carry = 1;
			}
			result = String.valueOf(sum%10) + result;

		}
		while(index1>0){
			int num1 = (int) s1.charAt(--index1) - '0';
			int sum = num1 + carry;
			carry = 0;
			if(sum >= 10){
				carry =1 ;
			}
			result = String.valueOf(sum%10) + result;
		}
		while(index2>0){
			int num2 = (int) s2.charAt(index2) - '0';
			int sum = num2 + carry;
			carry = 0;
			if(sum >= 10){
				carry =1 ;
			}
			result = String.valueOf(sum%10) + result;
		}
		if(carry == 1){
			result = String.valueOf(carry) + result;
		}
		
		return result;
		
		
		/*SIMPLE SOLUTION: 
		 * int summand1 = Integer.valueOf(s1);
		 * int summand2 = Integer.valueOf(s2);
		 * int sum = summand1 + summand2;
		 * return String.valueOf(sum);
		 */
	}

}
