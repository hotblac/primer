package org.dontpanic.primer.numbergenerator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class NumberGeneratorTest {

    @Mock private NumberSender numberSender;
    @InjectMocks private NumberGenerator generator;

    @Test
    void generator_isInitiallyStopped() {
        generator.sendNext();
        verify(numberSender, never()).sendNumber(anyInt());
    }

    @Test
    void firstNumber_is1MoreThanStartNumber() {
        generator.start(0);
        generator.sendNext();
        verify(numberSender).sendNumber(1);
    }

    @Test
    void nextNumber_is1More() {
        generator.start(0);
        for (int i=1; i<100; i++) {
            generator.sendNext();
            verify(numberSender).sendNumber(i);
        }
    }

    @Test
    void generator_isStopped() {
        generator.start(0);
        generator.sendNext();
        generator.stop();
        generator.sendNext();
        // Only the first sendNext sends a number
        verify(numberSender, times(1)).sendNumber(anyInt());
    }
}