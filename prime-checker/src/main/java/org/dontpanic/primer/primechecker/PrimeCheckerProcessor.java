package org.dontpanic.primer.primechecker;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.context.annotation.Bean;

import java.util.function.Function;

@EnableBinding(Processor.class)
public class PrimeCheckerProcessor {

    @Bean
    public Function<Integer, PrimeCandidate> checkPrime() {
        return i -> new PrimeCandidate(i, false);
    }

}
