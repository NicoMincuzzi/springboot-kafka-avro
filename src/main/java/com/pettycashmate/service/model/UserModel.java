package com.pettycashmate.service.model;

import com.pettycashmate.controller.representation.UserRepresentation;
import lombok.Data;

@Data(staticConstructor = "of")
public class UserModel {

    private String name;

    private String surname;

    private String country;


    public static UserModel from(UserRepresentation userRepresentation) {
        UserModel userModel = UserModel.of();
        userModel.setName(userRepresentation.getName());
        userModel.setSurname(userRepresentation.getSurname());
        userModel.setCountry(userRepresentation.getCountry());
        return userModel;
    }
}
