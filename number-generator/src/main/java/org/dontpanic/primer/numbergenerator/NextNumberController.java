package org.dontpanic.primer.numbergenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class NextNumberController {

    @Autowired private NumberGenerator generator;
    @Autowired private NumberSender sender;

    @GetMapping("/next")
    @ResponseStatus(value = HttpStatus.OK)
    public void sendNextNumber() {
        int next = generator.next();
        sender.sendNumber(next);
    }


}
