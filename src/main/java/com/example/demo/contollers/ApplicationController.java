package com.example.demo.contollers;

import com.example.demo.entities.Test;
import com.example.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Created by averma on 11/20/2017.
 * Name demo
 */
@RestController
@CrossOrigin(origins = "*")
public class ApplicationController {

    @Autowired
    private TestService service;

    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public ResponseEntity send(@RequestBody Test entity) throws Exception {
        return Optional.ofNullable(service.send(entity))
                .map(event -> new ResponseEntity(HttpStatus.OK))
                .orElseThrow(() -> new Exception("Could not Transfer money"));
    }
}
