package com.example.demo.kafka.consumerconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;

@Configuration
@EnableKafka
public class ReceiverConfiguration {

    @Autowired
    private KafkaProperties kafkaProperties;

    //region Simple Consumer
    //endregion
}
