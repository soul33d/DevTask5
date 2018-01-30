package com.goit.learning.service;

import com.goit.learning.dto.UserRegistrationDto;
import com.goit.learning.model.User;

public interface UserService {
    User findByEmail(String email);
    User save(UserRegistrationDto dto);
}
