package com.example.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class kafkaListener {

    private Logger log = LoggerFactory.getLogger(kafkaListener.class);

    @KafkaListener(topics = "hello")
    public void listen(String message) {
        log.info("KafkaListener -> " + message);
    }
}
