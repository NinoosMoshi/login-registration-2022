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
public class JwtLogin {

    private String email;
    private String password;
//    private Set<Role> roles = new HashSet<>();


}
