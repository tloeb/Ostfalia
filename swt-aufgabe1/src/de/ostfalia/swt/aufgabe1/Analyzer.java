package de.ostfalia.swt.aufgabe1;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;

/**
 * Created by Maic and Tobias on 20.03.14.
 */
public class Analyzer {
    public Set<Method> getAllPublicMethods ( String classname ){
        //Liefert immer die Klasse STRING zurück
    	//Class selectedClass = classname.getClass();
    	Set<Method> methods = new HashSet<Method>();
    	
    	Class<?> selectedClass;
		try {
			selectedClass = Class.forName(classname);
			
	        Collections.addAll(methods,selectedClass.getMethods());        
	        
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return methods;
    }

    public List<Class <?>> getInterfaces ( Object object ){
    	
    	List<Class<?>> interfaces;
    	interfaces = Arrays.asList(object.getClass().getInterfaces());
    	
        return interfaces;
    }

    boolean isToStringOverwritten (Class <?> clazz ){
        boolean bool = false;
        
		Method meth;
		
		if ( hasSuperclass(clazz) )
		{
			try {
				
				System.out.println(clazz.getSuperclass().getMethod("toString", null).getDeclaringClass().toString() + " != " + clazz.toString());
				if( clazz.getDeclaredMethod("toString", null) != null && clazz.getSuperclass().getMethod("toString", null).getDeclaringClass() != clazz)
					bool = true;
			} catch (NoSuchMethodException e) {
				bool = false;
			} catch (SecurityException e) {
				e.printStackTrace();
			}
		}
		
     	
    	return bool;
    }

    public boolean hasSuperclass (Class <?> clazz ){
    	
    	Class superclass = clazz.getSuperclass();
    	if (superclass == null)
    		return false;
    	else
    		return true;
    				
    }
}
