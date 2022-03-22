package com.example.prctice.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {
    public static final String TOPIC = "myFirstTopic";
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate ;

    public void publictoTopic(String message) {
        System.out.println("publishing to  topic" +TOPIC);
        this.kafkaTemplate.send(TOPIC, message);
    }
}
