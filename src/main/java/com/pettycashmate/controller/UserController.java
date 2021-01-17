package com.pettycashmate.controller;

import com.pettycashmate.controller.representation.UserRepresentation;
import com.pettycashmate.kafka.avro.User;
import com.pettycashmate.kafka.producer.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    private final Producer<User> producer;

    @Autowired
    UserController(Producer<User> producer) {
        this.producer = producer;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String createUser(@RequestBody UserRepresentation user) {
        String key = UUID.randomUUID().toString();
        this.producer.process(key, new User(user.getName(), user.getSurname(), user.getCountry()));
        return key;
    }
}