package com.goit.learning.controller;

import com.goit.learning.dto.UserRegistrationDto;
import com.goit.learning.model.User;
import com.goit.learning.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    @GetMapping("/login")
    public String doLogin() {
        return "login";
    }

    @GetMapping("/logout")
    public String doLogout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "forward:/login?logout";
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("user") @Valid UserRegistrationDto dto, BindingResult result) {
        User existing = userService.findByEmail(dto.getEmail());
        if (existing != null) {
            String existingEmailMessage = "There is already an account registered with that email";
            result.rejectValue("email", null, existingEmailMessage);
        }
        if (result.hasErrors()) {
            return "registration";
        }
        userService.save(dto);
        return "redirect:/registration?success";
    }
}
