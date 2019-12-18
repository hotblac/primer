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
    private Flux<T> flux = Flux.create(fluxSink -> this.fluxSink = fluxSink);

    public void add(T item) {
        if (!Objects.isNull(fluxSink)) {
            fluxSink.next(item);
        }
    }

    public Flux<T> getFlux() {
        return flux;
    }

}
