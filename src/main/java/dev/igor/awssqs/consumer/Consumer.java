package dev.igor.awssqs.consumer;

import io.awspring.cloud.sqs.annotation.SqsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    @SqsListener("queue")
    public void listen(Message message) {
        System.out.println("message " + message.content());
    }
}
