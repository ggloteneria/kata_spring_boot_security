package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;

@Controller
@RequestMapping("/admin/users")
public class AdminController {

    private final UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String showUsers(Model model) {
        model.addAttribute("users", userService.getUsers());
        return "users";
    }

    @GetMapping("/{id}")
    public String showUser(Model model, @PathVariable("id") Long id) {
        model.addAttribute("user", userService.findById(id));
        return "show";
    }

    @GetMapping("/create_user")
    public String showPageOfCreateUser(@ModelAttribute("user") User user) {
        return "create_user";
    }

    @PostMapping("/create_user")
    public String createUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/admin/users";
    }

    @GetMapping("/{id}/edit_user")
    public String showEditPage(Model model, @PathVariable("id") Long id) {
        model.addAttribute("user", userService.findById(id));
        return "edit_user";
    }

    @PostMapping("/{id}/edit_user")
    public String editUser(@ModelAttribute("user") User user, @PathVariable("id") Long id) {
        userService.update(id, user);
        return "redirect:/admin/users";
    }

    @PostMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return "redirect:/admin/users";
    }

}
