package com.ninos.security.controller;

import com.ninos.security.dto.JwtLogin;
import com.ninos.security.dto.LoginResponse;
import com.ninos.security.jwt.filter.JwtAuthenticationFilter;
import com.ninos.security.model.Role;
import com.ninos.security.model.User;
import com.ninos.security.service.RoleService;
import com.ninos.security.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class UserController {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;
    private final RoleService roleService;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody JwtLogin jwtLogin){
        return jwtAuthenticationFilter.login(jwtLogin);
    }


    @PostMapping("/register")
    public void register(@RequestBody JwtLogin jwtLogin){
        User user = new User();
        user.setEmail(jwtLogin.getEmail());
        user.setPassword(passwordEncoder.encode(jwtLogin.getPassword()));
        user.setActive(1);
        user.getRoles().add(roleService.getAllRoles().get(0));
        userService.addUser(user);
    }



}
