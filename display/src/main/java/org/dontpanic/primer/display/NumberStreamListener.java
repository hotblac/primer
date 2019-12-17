package org.dontpanic.primer.display;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import reactor.core.publisher.Flux;

@EnableBinding(Sink.class)
public class NumberStreamListener {

    private Logger logger = LoggerFactory.getLogger(NumberStreamListener.class);

    @StreamListener
    public void accept(@Input(Sink.INPUT) Flux<Integer> numbers) {
        numbers
                .map(n -> new PrimeCandidate(n, 0))
                .subscribe(pc -> logger.info(pc.toString()));
    }
}
