package org.dontpanic.primer.display;

public class PrimeCandidate {

    private int currentCandidate;
    private int lastPrime;

    public PrimeCandidate(int currentCandidate, int lastPrime) {
        this.currentCandidate = currentCandidate;
        this.lastPrime = lastPrime;
    }

    public int getCurrentCandidate() {
        return currentCandidate;
    }

    public void setCurrentCandidate(int currentCandidate) {
        this.currentCandidate = currentCandidate;
    }

    public int getLastPrime() {
        return lastPrime;
    }

    public void setLastPrime(int lastPrime) {
        this.lastPrime = lastPrime;
    }

    @Override
    public String toString() {
        return "PrimeCandidate{" +
                "currentCandidate=" + currentCandidate +
                ", lastPrime=" + lastPrime +
                '}';
    }
}
