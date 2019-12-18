package org.dontpanic.primer.display;

import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

import java.util.Objects;

/**
 * Build a Flux of given type.
 * @param <T> type of item in the Flux
 */
@Component
public class FluxBuilder<T> {

    private FluxSink<T> fluxSink = null;

    public void add(T item) {
        if (!Objects.isNull(fluxSink)) {
            fluxSink.next(item);
        }
    }

    public Flux<T> getFlux() {
        return Flux.create(fluxSink -> this.fluxSink = fluxSink);
    }

}
