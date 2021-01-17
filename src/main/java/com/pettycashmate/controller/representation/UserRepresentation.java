package com.pettycashmate.controller.representation;

import com.pettycashmate.kafka.avro.User;
import lombok.Data;
import org.springframework.lang.NonNull;

@Data(staticConstructor = "of")
public class UserRepresentation {

    @NonNull
    private String name;

    @NonNull
    private String surname;

    @NonNull
    private String country;

    public User from(UserRepresentation user) {
        return new User(user.getName(), user.getSurname(), user.getCountry());
    }
}
