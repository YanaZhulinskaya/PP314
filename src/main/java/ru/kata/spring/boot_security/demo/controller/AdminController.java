package ru.kata.spring.boot_security.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.security.Principal;

@Controller
@RequestMapping("/admin")
public class AdminController {


    private final UserService userService;

    public AdminController(UserService userService) {

        this.userService = userService;
    }

    @GetMapping()
    public String getAll(Model model, Principal principal) {
        model.addAttribute("newUser", new User());
        model.addAttribute("alluser", userService.getAllUsers());
        model.addAttribute("gguser", userService.getUserByName(principal.getName()));
        return "admin";
    }

    @PostMapping("/create")
    public String createUser(@ModelAttribute("newUser") User user) {
        userService.updateUserById(user);
        return "redirect:/admin";
    }

    @PatchMapping("/{id}")
    public String getUpdateUserForm(@ModelAttribute("user") User user) {
        userService.updateUserById(user);
        return "redirect:/admin";
    }

    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
        return "redirect:/admin";
    }
}