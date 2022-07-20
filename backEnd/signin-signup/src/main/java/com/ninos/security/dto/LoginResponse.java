package com.ninos.security.dto;

import com.ninos.security.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.HashSet;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {
    private String email;
    private String token;
//    private Set<Role> roles = new HashSet<>();


    public LoginResponse(String email) {
        this.email = email;
    }


}
