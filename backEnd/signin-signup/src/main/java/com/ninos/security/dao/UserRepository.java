package com.ninos.security.dao;

import com.ninos.security.model.Role;
import com.ninos.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    public User findUserByEmail(String email);

    public boolean existsByEmail(String email);

}
