package org.abymaly.code;

public class AchillesAndTurtle {

    public static int race(float speedTurtle, float speedAchilles, float distanceAT, float epsilon) {

        int count = 0;
        float currentTime;
        float achillesDistance = 0.f;

        while (distanceAT > epsilon) {
            currentTime = distanceAT / speedAchilles;
            achillesDistance = currentTime * speedAchilles + achillesDistance;
            distanceAT = currentTime * speedTurtle;
            ++count;
            System.out.println("Achilles przebiegł: " + achillesDistance);
            System.out.println("Do żółwia brakuje: " + currentTime);
        }

        return count;
    }

}
