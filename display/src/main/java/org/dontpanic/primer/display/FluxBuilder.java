package org.dontpanic.primer.display;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

import java.util.ArrayList;
import java.util.List;

/**
 * Build a Flux of given type.
 * @param <T> type of item in the Flux
 */
@Component
@Slf4j
public class FluxBuilder<T> {

    private final List<FluxSink<T>> fluxSinks = new ArrayList<>();

    public void add(T item) {
        log.debug("Received item for display: {}", item);
        fluxSinks.forEach(sink -> sink.next(item));
    }

    public Flux<T> getFlux() {
        return Flux.create(this.fluxSinks::add);
    }

}
