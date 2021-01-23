package com.pettycashmate.controller;

import com.pettycashmate.controller.representation.Success;
import com.pettycashmate.controller.representation.UserRepresentation;
import com.pettycashmate.service.UserService;
import com.pettycashmate.service.model.UserModel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    private final UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Success createUser(@RequestBody UserRepresentation user) {

        String key = userService.createUser(UserModel.from(user));
        Success success = Success.of();
        success.setId(key);
        return success;
    }
}