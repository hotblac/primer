package org.dontpanic.primer.display;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;

import java.util.function.Consumer;

@EnableBinding(Processor.class)
public class NumberStreamListener {

    /**
     * Consumer of new items from the stream
     */
    @Bean
    public Consumer<Flux<PrimeCandidate>> accept(FluxBuilder<PrimeCandidate> fluxBuilder) {
        return flux -> flux.subscribe(fluxBuilder::add);
    }
}
