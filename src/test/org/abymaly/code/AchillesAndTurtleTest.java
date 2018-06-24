package test.org.abymaly.code; 

import org.abymaly.code.AchillesAndTurtle;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

public class AchillesAndTurtleTest {

@Test
public void testRace01() {

    float speedTurtle = 1.f;
    float speedAchilles = 10.f;
    float distanceAT = 100.f;
    float epsilon = 1.e-6f;

    System.out.println(AchillesAndTurtle.race(speedTurtle, speedAchilles, distanceAT, epsilon));

} 


} 
