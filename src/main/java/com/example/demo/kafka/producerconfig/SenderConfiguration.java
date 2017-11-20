package com.example.demo.kafka.producerconfig;

import com.example.demo.entities.Test;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.Map;

/**
 * Created by averma on 11/20/2017.
 * Name demo
 */
@Configuration
public class SenderConfiguration {
    @Autowired
    private KafkaProperties kafkaProperties;

    //region Test Sender
    @Bean
    public ProducerFactory<Integer, Test> producerFactory() {

        Map<String, Object> props = kafkaProperties.buildProducerProperties();
        props.put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, true);
        props.put(ProducerConfig.MAX_BLOCK_MS_CONFIG, 5000);
        DefaultKafkaProducerFactory defaultKafkaProducerFactory = new DefaultKafkaProducerFactory<>(props);
        defaultKafkaProducerFactory.setTransactionIdPrefix("my.transaction.id.");
        return defaultKafkaProducerFactory;
    }

    @Bean
    public KafkaTemplate<Integer, Test> kafkaTemplate() {
        KafkaTemplate template = new KafkaTemplate<>(producerFactory());
        template.setDefaultTopic("topic-2");
        return template;
    }

    //endregion
}
