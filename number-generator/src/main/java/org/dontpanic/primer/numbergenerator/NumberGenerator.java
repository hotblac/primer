package org.dontpanic.primer.numbergenerator;

import org.springframework.stereotype.Component;

@Component
public class NumberGenerator {

    private int current = 0;

    public int next() {
        return current += 1;
    }

}
