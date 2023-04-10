package com.enginaar.sessionauthtemplate.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.enginaar.sessionauthtemplate.entity.User;
import com.enginaar.sessionauthtemplate.repository.UserRepository;

import lombok.AllArgsConstructor;


@Controller
@AllArgsConstructor
public class AuthController {
    private PasswordEncoder encoder;
    private UserRepository userRepo;
   
    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("user", new User());
        
        return "register";
    }
    
    @PostMapping("/process_register")
    public String processRegister(User user) {
        Optional<User> existed = userRepo.findByEmail(user.getEmail());
        Assert.isTrue(existed.isEmpty(), "User already registered");
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword); 
         
        userRepo.save(user);
         
        return "register.success";
    }

    @GetMapping("/app/users")
    public String listUsers(Model model) {
        List<User> listUsers = userRepo.findAll();
        model.addAttribute("listUsers", listUsers);
        
        return "users";
    }
}
