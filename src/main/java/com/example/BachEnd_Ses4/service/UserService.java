package com.example.BachEnd_Ses4.service;

import com.example.BachEnd_Ses4.model.Role;
import com.example.BachEnd_Ses4.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String userName, String roleName);
    User getUser(String userName);
    List<User> getUsers();

    List<Role> getRole();
}
