package com.example.prctice.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    @KafkaListener(topics="myFirstTopic",groupId= "myGroup")
    public void consumeFromtopic(String message) {
        System.out.println("Consumed Message ::" +message);
    }
}
