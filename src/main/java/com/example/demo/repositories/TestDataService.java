package com.example.demo.repositories;

import com.example.demo.entities.Test;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by averma on 11/20/2017.
 * Name demo
 */
public interface TestDataService extends JpaRepository<Test, Integer> {
    Test findById(int id);
}
