package org.abymaly.code;

public class Sieve {

    public int[] createSieve(int maxVal) {

        // TODO: takie podstawienie size jest raczej bez sensu, ale to jest jakiś początek ograniczenia wielkości tablicy do pierwiastka szukanej wartości.
        int size = maxVal;

        if (maxVal % Math.sqrt(maxVal) == 0) {
            size = (int) Math.sqrt(maxVal);
        }

        int[] sieve = new int[size];

        for (int i = 0; i < sieve.length; ++i) {
            sieve[i] = i + 1;
        }

        for (int idx = 1; idx < sieve.length; ++idx) {
            for (int nextIdx = idx + 1; nextIdx < sieve.length; ++nextIdx) {
                if (sieve[idx] != 0) {
                    if (sieve[nextIdx] % sieve[idx] == 0) {
                        sieve[nextIdx] = 0;
                    }
                }
            }
        }
        return sieve;
    }

    public String sieveToString(int[] sieve) {

        StringBuilder sieveToString = new StringBuilder();

        for (int i = 0; i < sieve.length; ++i) {
            sieveToString
                    .append(sieve[i])
                    .append("; ");
        }

        return sieveToString.toString();
    }

    public boolean isPrimary(int val) {
        boolean isPrimary = false;
        Sieve sieve = new Sieve();
        int[] newSieve = sieve.createSieve(val);

        for (int i = 0; i < newSieve.length; ++i) {
            if (val == newSieve[i]) {
                isPrimary = true;
            }
        }

        return isPrimary;
    }
}