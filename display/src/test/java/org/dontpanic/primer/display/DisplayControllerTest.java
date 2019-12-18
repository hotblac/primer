package org.dontpanic.primer.display;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;

import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = DisplayController.class)
class DisplayControllerTest {

    @Autowired private WebTestClient webTestClient;
    @MockBean private FluxBuilder<PrimeCandidate> primeCandidateFluxBuilder;

    @BeforeEach
    void setUp() {
        when(primeCandidateFluxBuilder.getFlux())
                .thenReturn(Flux.empty());
    }

    @Test
    void index_displaysPrimeCandidateList() throws Exception {
        webTestClient
                .get().uri("/")
                .exchange()
                .expectStatus().isOk();
    }
}