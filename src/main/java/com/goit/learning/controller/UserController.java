package com.goit.learning.controller;

import com.goit.learning.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

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
    public ModelAndView doGetDeleteUsers(String id) {
        userService.deleteById(UUID.fromString(id));
        return doGetUsers();
    }
}
