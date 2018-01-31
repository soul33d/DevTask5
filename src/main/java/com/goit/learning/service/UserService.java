package com.goit.learning.service;

import com.goit.learning.dto.UserRegistrationDto;
import com.goit.learning.model.User;

import java.util.List;

public interface UserService<ID> {
    User findByEmail(String email);
    User save(UserRegistrationDto dto);
    List<User> findAll();
    void deleteById(ID id);
}
