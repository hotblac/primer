package org.dontpanic.primer.display;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;

import java.util.function.Consumer;

@EnableBinding(Sink.class)
public class NumberStreamListener {

    private Logger logger = LoggerFactory.getLogger(NumberStreamListener.class);

    @Bean
    public Consumer<Flux<Integer>> accept(EmitterRegistry registry) {
        return flux -> flux
                .map(n -> new PrimeCandidate(n, 0))
                .subscribe(pc -> registry.get().ifPresent(e -> e.next(pc)));
    }
}
