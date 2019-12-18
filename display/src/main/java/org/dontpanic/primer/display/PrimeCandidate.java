package org.dontpanic.primer.display;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrimeCandidate that = (PrimeCandidate) o;
        return currentCandidate == that.currentCandidate &&
                lastPrime == that.lastPrime;
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentCandidate, lastPrime);
    }
}
