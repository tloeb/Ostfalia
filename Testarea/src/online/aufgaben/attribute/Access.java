package online.aufgaben.attribute;

public class Access {
	
	public final String FOO;
    private int bar;
    private static int number = 12; 
	
    public Access(String str) { 
        FOO = str;
    }
	
    public static int getNumber() {
        return number;
    }

    public static void setNumber(int newNumber) {
        number = newNumber;
    }

    public int getBar() {
        return bar;
    }

    public void setBar(int bar) {
        this.bar = bar;
    }

}
