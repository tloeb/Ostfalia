package packb;
public class ExcFinally {
	
    public void m1(int i) {
        try {
            m2(i);
        } catch (Exc2 e) {
            System.out.println("C1");/*C1*/
        } finally {
        	System.out.println("F1");/*F1*/
        }

    }

    public void m2(int i) throws Exc2 {
        try {
            m3(i);
            if (i == 1) {
                throw new Exc2();
            }
        } finally {
        	System.out.println("F1");/*F2*/
        }
    }

    public void m3(int i) {
        try {
            if (i == 2) {
                throw new Exc1();
            }
        } catch (Exc1 e) {
        	System.out.println("C3");/*C3*/
        }
    }
    
    public static void main(String args[]){
    	ExcFinally obj = new ExcFinally();
        obj.m1(2);
    }
}