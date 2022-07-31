package com.ninos.security.jwt.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.ninos.security.dao.UserRepository;
import com.ninos.security.dto.LoginResponse;
import com.ninos.security.dto.RoleModel;
import com.ninos.security.dto.UserPrincipal;
import com.ninos.security.dto.JwtLogin;
import com.ninos.security.jwt.JwtProperties;

import com.ninos.security.model.User;
import com.ninos.security.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.*;

@AllArgsConstructor
@Service
public class JwtAuthenticationFilter {


    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final RoleService roleService;



    public LoginResponse login(JwtLogin jwtLogin){
        Authentication authenticate = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(jwtLogin.getEmail(), jwtLogin.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authenticate);

        LoginResponse loginResponse = new LoginResponse();
        User user = userRepository.findUserByEmail(jwtLogin.getEmail());
        List<RoleModel> roles = getRoleList(user);

        String token = generateToken(authenticate);
        return new LoginResponse(jwtLogin.getEmail(), token, roles);
    }

    private List<RoleModel> getRoleList(User user){
        List<RoleModel> roleList = new ArrayList<>();
        for(int i=0; i< user.getRoles().size(); i++) {
            RoleModel roleModel = new RoleModel();
            roleModel.setRoleName(user.getRoles().get(i).getRoleName());
            roleList.add(roleModel);
        }
        return roleList;
    }



    private String generateToken(Authentication authResult){
        // Grab principal
        UserPrincipal principal = (UserPrincipal) authResult.getPrincipal();
        System.out.println(principal.getUsername());

        // create Jwt Token
        String token = JWT.create()
                .withSubject(principal.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + JwtProperties.EXPIRATION_TIME))
                .sign(Algorithm.HMAC512(JwtProperties.SECRET.getBytes()));
        return token;
    }



}









