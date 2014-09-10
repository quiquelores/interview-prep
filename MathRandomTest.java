
public class MathRandomTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int first=0, second = 0;
		for(int i = 0; i< 100000000; i++){
			if(Math.random() < Math.random()){
				first ++;
			}
			else{
				second++;
			}
		}
		System.out.println(first);
		System.out.println(second);
	}

}
