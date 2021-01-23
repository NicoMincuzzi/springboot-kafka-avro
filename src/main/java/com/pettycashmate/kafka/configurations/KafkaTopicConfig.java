package com.pettycashmate.kafka.configurations;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

@Configuration
public class KafkaTopicConfig {

    @Value("${topic.name}")
    private String topicName;

    @Value("${topic.replication-factor}")
    private short replicationFactor;

    @Bean
    public NewTopic createTopic() {
        return new NewTopic(topicName, new HashMap<>());
    }
}
