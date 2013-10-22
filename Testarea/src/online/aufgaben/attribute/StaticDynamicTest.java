package online.aufgaben.attribute;

public class StaticDynamicTest {
    private static int n = 0;
    private int value = 0;
    
    public StaticDynamicTest(int value) {
            this();  //Aufruf des Konstruktors StaticDynamicTest()
            this.value = value;
    }
    
    public StaticDynamicTest() { 
            n = n + 1;
    }

    
    public static int getN() {
        return n;
    }

    public static void setN(int n) {
        StaticDynamicTest.n = n;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}