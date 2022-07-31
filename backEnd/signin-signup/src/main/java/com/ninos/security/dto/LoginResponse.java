package com.ninos.security.dto;

import com.ninos.security.model.Role;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {
    private String email;
    private String token;
   private List<RoleModel> roles;

    public LoginResponse(String email) {
        this.email = email;
    }


}
