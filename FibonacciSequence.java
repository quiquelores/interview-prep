
public class FibonacciSequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i = 0; i < 50; i ++){
			System.out.println(f(i));
		}
	}
	public static int f(int n){
		if(n == 0 || n == 1){
			return n;
		}
		return (f(n-1) + f(n-2));
	}

}
