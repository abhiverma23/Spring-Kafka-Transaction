package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by averma on 11/20/2017.
 * Name demo
 */
@Entity
@Table(name = "test")
public class Test {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    public Test() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
