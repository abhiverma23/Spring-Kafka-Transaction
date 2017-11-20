package com.example.demo.service;

import com.example.demo.entities.Test;
import com.example.demo.repositories.TestDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by averma on 11/20/2017.
 * Name demo
 */
@Service
public class TestService {

    @Autowired
    private TestDataService dataService;

    @Autowired
    private KafkaTemplate<Integer, Test> kafkaTemplate;

    @Transactional
    public Test send(Test entity) {


        kafkaTemplate.sendDefault(entity);

        Test e = dataService.save(entity);

        return entity;
    }
}
