package com.pettycashmate.controller.representation;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data(staticConstructor = "of")
public class Success {
    String id;
    HttpStatus Code = HttpStatus.CREATED;
}
