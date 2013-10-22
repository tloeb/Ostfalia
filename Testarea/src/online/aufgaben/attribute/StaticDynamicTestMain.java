package online.aufgaben.attribute;

public class StaticDynamicTestMain {
	
	  public static void main(String[] args) {
			StaticDynamicTest s1 = new StaticDynamicTest(54);
			StaticDynamicTest s2 = new StaticDynamicTest(13);
			System.out.println(s1.getValue()+ "----" + s2.getValue()+ "----" + StaticDynamicTest.getN());
		        s2.setValue(20);
		    System.out.println(s1.getValue()+ "----" + s2.getValue()+ "----" + StaticDynamicTest.getN());
		        StaticDynamicTest.setN(s1.getN());
		        new StaticDynamicTest();
		        new StaticDynamicTest();
		        new StaticDynamicTest();
		    System.out.println(s1.getValue()+ "----" + s2.getValue()+ "----" + StaticDynamicTest.getN());
		        s2.setValue(s2.getN());
		    System.out.println(s1.getValue()+ "----" + s2.getValue()+ "----" + StaticDynamicTest.getN());
		    }

}
