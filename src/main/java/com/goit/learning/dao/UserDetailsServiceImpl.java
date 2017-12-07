package com.goit.learning.dao;

import com.goit.learning.model.User;
import com.goit.learning.model.UserDetailsImpl;
import com.goit.learning.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if (user == null) throw new UsernameNotFoundException("There is no user with email: " + username);
        return new UserDetailsImpl(user);
    }
}
