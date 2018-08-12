package test.org.abymaly.code; 

import org.abymaly.code.RotLeft;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

public class RotLeftTest { 

@Test
public void testToString() throws Exception { 
    RotLeft rotLeft = new RotLeft();
    int [] arr = {1, 2, 3, 4, 5};
    rotLeft.rotLeft(arr, 4);
    System.out.println(rotLeft.toString(arr));
} 


} 
