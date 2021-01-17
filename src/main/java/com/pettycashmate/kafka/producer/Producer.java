package com.pettycashmate.kafka.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Producer<T> {

    @Value("${topic.name}")
    private String topic;

    private final KafkaTemplate<String, T> kafkaTemplate;

    @Autowired
    public Producer(KafkaTemplate<String, T> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void process(String key, T t) {
        this.kafkaTemplate.send(this.topic, key, t);
        log.info("Produced user -> {}", t);
    }
}
