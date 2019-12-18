package org.dontpanic.primer.display;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.test.binder.MessageCollector;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class NumberStreamListenerTest {

    @Autowired private Sink channels;
    @Autowired private MessageCollector collector;
    @MockBean private FluxBuilder<PrimeCandidate> fluxBuilder;

    @Test
    void messageIsCaptured() {
        channels.input().send(MessageBuilder.withPayload("42").build());
        verify(fluxBuilder).add(new PrimeCandidate(42, 0));
    }
}