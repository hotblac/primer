package org.dontpanic.primer.primechecker;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.context.annotation.Bean;

import java.util.function.Function;

@Slf4j
@EnableBinding(Processor.class)
public class PrimeCheckerProcessor {

    @Autowired private PrimeChecker checker;

    @Bean
    public Function<Integer, PrimeCandidate> checkPrime() {

        return i -> {
            PrimeCandidate result = new PrimeCandidate(i, checker.isPrime(i));
            log.debug("Checked prime: {}", result);
            return result;
        };
    }

}
