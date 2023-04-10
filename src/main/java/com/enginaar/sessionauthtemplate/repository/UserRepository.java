package com.enginaar.sessionauthtemplate.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.enginaar.sessionauthtemplate.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

    Optional<User> findByEmail(String email);
    
}
