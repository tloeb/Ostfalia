
public class testingArray {

	
	
	public static void main(String[] args) {
		
		int [][] test = new int[4][6];
		
		System.out.println(randomNumber(4, 20));

	}

	public static int randomNumber (int min, int max) {
		double i = Math.random()* (max - min) + min;
		return  (int) i;
	}
}
