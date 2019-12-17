package org.dontpanic.primer.display;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.thymeleaf.spring5.context.webflux.IReactiveDataDriverContextVariable;
import org.thymeleaf.spring5.context.webflux.ReactiveDataDriverContextVariable;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

@Controller
public class DisplayController {

    private static final String DISPLAY_VIEW = "display";

    @GetMapping("/")
    public String currentPrimeCandidate(Model model) {
        List<PrimeCandidate> stubCandidates = Arrays.asList(
                new PrimeCandidate(1, 0),
                new PrimeCandidate(2, 2),
                new PrimeCandidate(3, 3),
                new PrimeCandidate(4, 3),
                new PrimeCandidate(5, 5)
        );
        Flux<PrimeCandidate> fluxStream = Flux.fromIterable(stubCandidates).delayElements(Duration.ofMillis(2000));
        IReactiveDataDriverContextVariable reactiveCandidates = new ReactiveDataDriverContextVariable(fluxStream, 1);
        model.addAttribute("candidates", reactiveCandidates);

        return DISPLAY_VIEW;
    }
}
