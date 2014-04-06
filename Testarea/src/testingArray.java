import java.util.Arrays;


public class testingArray {

	
	
	public static void main(String[] args) {
		
		int [][] test = new int[5][5];
		
		for(int k = 1; k <= 3; k++) {
			for (int j = 1; j <= 3; j++) {
				int buf = Math.abs(j-k);
				test[j][k] = (int) Math.pow(2, buf);
				System.out.println("k: " + k + "; j:" + j + " = " + test[j][k]);
			}
		}
		

	}

	
}
