package online.aufgaben.collections;

import java.util.*;

public class Collections {

	public static void main(String[] args) {
		TreeSet<Integer> uSet = new TreeSet<Integer>();
        uSet.add(6);
        uSet.add(1);
        uSet.add(6);
        uSet.add(uSet.size());
        uSet.add(9);
        uSet.add(4);
        uSet.remove(uSet.size());
        uSet.add(3);
        uSet.add(2);
        uSet.remove(3);
        
        System.out.println(uSet.toString());
        System.out.println(uSet.size());

	}

}
