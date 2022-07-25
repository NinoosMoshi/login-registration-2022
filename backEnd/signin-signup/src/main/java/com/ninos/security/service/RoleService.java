package com.ninos.security.service;

import com.ninos.security.dao.RoleRepository;
import com.ninos.security.model.Role;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;



@AllArgsConstructor
@Service
public class RoleService {

    private RoleRepository roleRepository;


    @Transactional(readOnly = true)
    public List<Role> getAllRoles(){
        return roleRepository.findAll();
    }



}