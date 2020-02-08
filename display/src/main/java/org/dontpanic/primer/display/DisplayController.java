package org.dontpanic.primer.display;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DisplayController {

    static final String DISPLAY_VIEW = "display";

    @GetMapping("/")
    public String currentPrimeCandidate() {
        return DISPLAY_VIEW;
    }

}
