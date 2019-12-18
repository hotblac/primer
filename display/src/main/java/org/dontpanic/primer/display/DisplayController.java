package org.dontpanic.primer.display;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.thymeleaf.spring5.context.webflux.IReactiveDataDriverContextVariable;
import org.thymeleaf.spring5.context.webflux.ReactiveDataDriverContextVariable;
import reactor.core.publisher.Flux;

@Controller
public class DisplayController {

    private static final String DISPLAY_VIEW = "display";

    @Autowired private EmitterRegistry registry;

    @GetMapping("/")
    public String currentPrimeCandidate(Model model) {
        Flux<PrimeCandidate> flux = Flux.create(emitter -> {
            registry.register(emitter);
        });

        IReactiveDataDriverContextVariable reactiveCandidates = new ReactiveDataDriverContextVariable(flux, 1);
        model.addAttribute("candidates", reactiveCandidates);

        return DISPLAY_VIEW;
    }

}
