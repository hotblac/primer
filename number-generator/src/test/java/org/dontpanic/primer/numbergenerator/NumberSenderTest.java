package org.dontpanic.primer.numbergenerator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.cloud.stream.test.binder.MessageCollector;
import org.springframework.messaging.Message;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class NumberSenderTest {

    @Autowired private NumberSender sender;
    @Autowired private MessageCollector messageCollector;
    @Autowired private Source source;
    // Override NumberGenerator so that numbers are not sent by scheduler
    @MockBean private NumberGenerator noopGenerator;

    @Test
    void testNumberIsSent() throws Exception {
        sender.sendNumber(42);

        Message sentMessage = messageCollector.forChannel(source.output()).poll(1, TimeUnit.SECONDS);
        assertNotNull(sentMessage, "Message not received on channel");
        String payload = sentMessage.getPayload().toString();
        assertEquals("42", payload);
    }
}