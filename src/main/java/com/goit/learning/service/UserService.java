package com.goit.learning.service;

import com.goit.learning.dto.UserRegistrationDTO;
import com.goit.learning.model.Role;
import com.goit.learning.model.User;

import java.util.List;

public interface UserService<ID> {
    User findByEmail(String email);
    User save(UserRegistrationDTO dto);
    List<User> findAll();
    void deleteById(ID id);
    void updateUser(String id, String firstName, String lastName, String email, Role role);
}
