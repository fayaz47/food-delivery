package com.example.prctice.controller;

import com.example.prctice.kafka.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafkaapp")
public class KafkaController {

    @Autowired
    Producer producer;

    @PostMapping(value="/postMessage")
    public void postMessages(@RequestParam("msg") String message) {

        producer.publictoTopic(message);

    }
}
