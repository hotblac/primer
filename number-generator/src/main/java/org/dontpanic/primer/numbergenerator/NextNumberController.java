package org.dontpanic.primer.numbergenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class NextNumberController {

    @Autowired private NumberGenerator generator;

    @GetMapping("/start")
    @ResponseStatus(value = HttpStatus.OK)
    public void start(@RequestParam(defaultValue = "0") int startAt) {
        generator.start(startAt);
    }

    @GetMapping("/stop")
    @ResponseStatus(value = HttpStatus.OK)
    public void stop() {
        generator.stop();
    }


}
