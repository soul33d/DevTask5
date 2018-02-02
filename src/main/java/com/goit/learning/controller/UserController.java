package com.goit.learning.controller;

import com.goit.learning.model.Role;
import com.goit.learning.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@PreAuthorize("hasRole('ROLE_ADMIN')")
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ModelAndView doGetUsers() {
        return new ModelAndView("users", "usersList", userService.findAll());
    }

    @SuppressWarnings("unchecked")
    @GetMapping("/users/delete")
    public ModelAndView doGetDeleteUser(String id) {
        userService.deleteById(UUID.fromString(id));
        return doGetUsers();
    }

    @GetMapping("/users/edit")
    public ModelAndView doGetEditUser(String email) {
        ModelAndView modelAndView = new ModelAndView("user_edit");
        modelAndView.addObject("user", userService.findByEmail(email));
        modelAndView.addObject("roles", Role.values());
        return modelAndView;
    }

    @PostMapping("/users/edit")
    public ModelAndView doPostEditUser(String id, String firstName, String lastName, String email, String role) {
        System.out.println(id + firstName + lastName + email + role);
        userService.updateUser(id, firstName, lastName, email, Role.valueOf(role));
        return doGetUsers();
    }
}
