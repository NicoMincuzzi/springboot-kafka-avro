package com.pettycashmate.controller.representation;

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

}
