package org.dontpanic.primer.display;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.reactive.result.view.Rendering;;
import org.thymeleaf.spring5.context.webflux.ReactiveDataDriverContextVariable;
import reactor.core.publisher.Flux;

@Controller
public class DisplayController {

    private static final String DISPLAY_VIEW = "display";

    @Autowired private FluxBuilder<PrimeCandidate> primeCandidateFluxBuilder;

    @GetMapping("/")
    public Rendering currentPrimeCandidate() {
        Flux<PrimeCandidate> primeCandidates = primeCandidateFluxBuilder.getFlux();
        return Rendering.view(DISPLAY_VIEW)
                .modelAttribute("candidates", new ReactiveDataDriverContextVariable(primeCandidates, 1))
                .build();
    }

}
