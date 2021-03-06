package org.dontpanic.primer.primechecker;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.test.binder.MessageCollector;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class PrimeCheckerProcessorTest {

    @Autowired private Processor processor;
    @Autowired private MessageCollector messageCollector;
    @MockBean private PrimeChecker checker;

    @Test
    void integerIn_primeCandidateOut() throws Exception {
        when(checker.isPrime(42)).thenReturn(true);
        processor.input().send(MessageBuilder.withPayload("42").build());
        Message output = messageCollector.forChannel(processor.output()).poll(1, TimeUnit.SECONDS);
        assertEquals("{\"number\":42,\"prime\":true}", output.getPayload());
    }
}