package com.enginaar.sessionauthtemplate.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.enginaar.sessionauthtemplate.config.EnginaarUserDetails;
import com.enginaar.sessionauthtemplate.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EnginaarUserService implements UserDetailsService {

    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        var user = userRepo.findByEmail(email);
        Assert.isTrue(user.isPresent(), "User not found");
        return new EnginaarUserDetails(user.get());
    }
    
}
