package com.goit.learning.service;

import com.goit.learning.dto.UserRegistrationDto;
import com.goit.learning.model.Role;
import com.goit.learning.model.User;
import com.goit.learning.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User save(UserRegistrationDto dto) {
        User user = new User(dto.getFirstName(), dto.getLastName(), dto.getEmail(),
                passwordEncoder.encode(dto.getPassword()), Role.USER);
        return userRepository.save(user);
    }
}
