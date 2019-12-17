package org.dontpanic.primer.numbergenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

@EnableBinding(Source.class)
public class NumberSender {

    @Autowired
    private Source source;

    public void sendNumber(int number) {
        Message<Integer> message = MessageBuilder.withPayload(number).build();
        source.output().send(message);
    }
}
