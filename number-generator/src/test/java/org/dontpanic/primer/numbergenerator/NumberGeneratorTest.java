package org.dontpanic.primer.numbergenerator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberGeneratorTest {

    private NumberGenerator generator = new NumberGenerator();

    @Test
    void firstNumber_is1() {
        assertEquals(1, generator.next());
    }

    @Test
    void nextNumber_is1More() {
        int prev = 0;
        int current;
        for (int i=0; i<99; i++) {
            current = generator.next();
            assertEquals(prev + 1, current);
            prev = current;
        }
    }
}