package com.pettycashmate.service;

import com.pettycashmate.kafka.avro.Residency;
import com.pettycashmate.kafka.avro.User;
import com.pettycashmate.kafka.producer.Producer;
import com.pettycashmate.service.model.UserModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class UserService {

    private final Producer<User> producer;

    @Autowired
    UserService(Producer<User> producer) {
        this.producer = producer;
    }

    public String createUser(UserModel userModel) {
        String key = UUID.randomUUID().toString();
        this.producer.process(key, new User(
                        userModel.getName(),
                        userModel.getSurname(),
                        userModel.getCountry(),
                        true,
                        null,
                        Residency.newBuilder()
                                .setAddress("Address Street")
                                .setZipCode("00000")
                                .setCity("")
                                .setState("")
                                .setCountry("Italy")
                                .build()
                )
        );
        return key;
    }

}
