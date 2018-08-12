package org.abymaly.code;

public class Sieve {

    public boolean[] createSieve(int maxVal) {

        boolean[] sieve = new boolean[maxVal + 1];

        for (int i = 0; i <= maxVal; ++i) {
            sieve[i] = true;
        }

        sieve[0] = false;
        sieve[1] = false;

        for (int idx = 2; idx <= maxVal; ++idx) {
            if (sieve[idx]) {
                for (int i = idx * 2; i <= maxVal; i += idx) {
                    sieve[i] = false;
                }
            }
        }

        return sieve;
    }

    public String sieveToString(boolean[] sieve) {

        StringBuilder sieveToString = new StringBuilder();

        for (int i = 0; i < sieve.length; ++i) {
            sieveToString
                    .append(sieve[i])
                    .append("; ");
        }

        return sieveToString.toString();
    }

    public boolean isPrimary(int val) {
        Sieve sieve = new Sieve();
        boolean[] newSieve = sieve.createSieve(val);
        return newSieve[val];
    }
}