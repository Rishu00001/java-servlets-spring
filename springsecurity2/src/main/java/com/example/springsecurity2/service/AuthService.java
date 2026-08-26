package com.example.springsecurity2.service;

import com.example.springsecurity2.dto.UserRegisterRequestDto;
import com.example.springsecurity2.dto.UserRegisterResponseDto;
import com.example.springsecurity2.entity.Role;
import com.example.springsecurity2.entity.User;
import com.example.springsecurity2.repository.RoleRepository;
import com.example.springsecurity2.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    public AuthService(UserRepository userRepository,
                       RoleRepository roleRepository,
                       PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }
    public UserRegisterResponseDto
    registerUser(UserRegisterRequestDto registerRequestDto){
        User user = new User();
        user.setUsername(registerRequestDto.getUsername());
        //hash the password before setting the password
        String hashedPassword = passwordEncoder
                .encode(registerRequestDto.getPassword());
        //now store the password in the database
        user.setPassword(hashedPassword);
        user.setEnabled(true);

        Role role = roleRepository.findByName("ROLE_USER").get();
        user.getRoles().add(role);

        userRepository.save(user);

        //map the user to dto
        UserRegisterResponseDto registerResponseDto
                 = new UserRegisterResponseDto();
        registerResponseDto.setUsername(user.getUsername());
        registerResponseDto.setMessage("user created");
        return registerResponseDto;
    }
}
