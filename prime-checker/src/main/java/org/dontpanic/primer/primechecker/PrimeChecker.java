package org.dontpanic.primer.primechecker;

import org.apache.commons.math3.primes.Primes;
import org.springframework.stereotype.Component;

@Component
public class PrimeChecker {

    public boolean isPrime(int i) {
        return Primes.isPrime(i);
    }
}
