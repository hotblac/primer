package org.dontpanic.primer.numbergenerator;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class NumberGenerator {

    private final NumberSender numberSender;
    private int current = 0;
    private boolean enabled = false;

    public NumberGenerator(NumberSender numberSender) {
        this.numberSender = numberSender;
    }

    public void start(int startAt) {
        current = startAt;
        enabled = true;
    }

    public void stop() {
        enabled = false;
    }

    @Scheduled(fixedDelay=500)
    public void sendNext() {
        if (enabled) {
            numberSender.sendNumber(++current);
        }
    }

}
