package dev.igor.awssqs.producer;

import dev.igor.awssqs.consumer.Message;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Producer implements CommandLineRunner {
    private final SqsTemplate sqsTemplate;

    public Producer(SqsTemplate sqsTemplate) {
        this.sqsTemplate = sqsTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        var SQS = "https://localhost.localstack.cloud:4566/000000000000/queue";
        for (int i = 0; i < 10; i++) {
            System.out.println("producer " + i);
            sqsTemplate.send(SQS, new Message("consumer"));
        }
    }
}
