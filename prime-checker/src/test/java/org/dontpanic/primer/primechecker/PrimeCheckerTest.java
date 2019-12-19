package org.dontpanic.primer.primechecker;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.*;

@Timeout(value = 10)
class PrimeCheckerTest {

    private PrimeChecker checker = new PrimeChecker();

    @Test
    void number0_isNotPrime() {
        assertFalse(checker.isPrime(0));
    }

    @Test
    void number1_isNotPrime() {
        assertFalse(checker.isPrime(1));
    }

    @Test
    void number2_isPrime() {
        assertTrue(checker.isPrime(2));
    }

    @Test
    void intMax_isPrime() {
        assertTrue(checker.isPrime(Integer.MAX_VALUE));
    }

    @Test
    void intMaxMinus2_isNotPrime() {
        assertFalse(checker.isPrime(Integer.MAX_VALUE - 2));
    }
}