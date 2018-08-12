package org.abymaly.code;

public class CommonDivision {

    public void maxCommonDivision (int a, int b) {
        int steps = 0;
        int c = 0;

        while (b != 0) {
            c = a%b;
            a = b;
            b = c;
            steps++;
        }

        System.out.println("divison: " + a + "\nsteps: " + steps);

    }
}
