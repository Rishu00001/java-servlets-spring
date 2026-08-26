package com.example.springsecurity2.service;

import com.example.springsecurity2.entity.Role;
import com.example.springsecurity2.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    private RoleRepository roleRepository;
    public RoleService(RoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }
    public void addRole(Role role){
        roleRepository.save(role);
    }
}
