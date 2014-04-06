
public class BruteForce {

	public static void main(String ARGS[]) {
		for (int x = 0; x < 100000; x++) {
			for (int y = 0; y < 100000; y++) {
				if (6*x+2*y==1)
					System.out.println("Found: x= " + x +"; y= "+ y );	
			}
		}
	}
}
