package org.dontpanic.primer.display;

import org.springframework.stereotype.Component;
import reactor.core.publisher.FluxSink;

import java.util.Optional;

@Component
public class EmitterRegistry {

    private FluxSink<PrimeCandidate> fluxSink = null;

    public void register(FluxSink<PrimeCandidate> fluxSink) {
        this.fluxSink = fluxSink;
    }

    public Optional<FluxSink<PrimeCandidate>> get() {
        return Optional.ofNullable(fluxSink);
    }

}
