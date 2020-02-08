package org.dontpanic.primer.display;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

class FluxBuilderTest {

    private FluxBuilder<String> builder = new FluxBuilder<>();

    @Test
    void getFluxBeforeAdd_isEmpty() {
        Flux<String> flux = builder.getFlux();
        StepVerifier.create(flux)
                .expectNoAccessibleContext();
    }

    @Test
    void getFluxAfterAdd_containsAddedItem() {
        builder.add("Hello world");
        Flux<String> flux = builder.getFlux();
        StepVerifier.create(flux)
                .expectNext("Hello world");
    }
}