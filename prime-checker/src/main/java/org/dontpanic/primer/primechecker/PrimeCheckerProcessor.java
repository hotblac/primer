package org.dontpanic.primer.primechecker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.context.annotation.Bean;

import java.util.function.Function;

@EnableBinding(Processor.class)
public class PrimeCheckerProcessor {

    @Autowired private PrimeChecker checker;

    @Bean
    public Function<Integer, PrimeCandidate> checkPrime() {
        return i -> new PrimeCandidate(i, checker.isPrime(i));
    }

}
