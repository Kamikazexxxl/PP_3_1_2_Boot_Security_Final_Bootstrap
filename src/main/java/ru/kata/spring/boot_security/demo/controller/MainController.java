package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.security.Principal;
import java.util.List;

@Controller
public class   MainController {

    private final UserService userService;

    public MainController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/user")
    public String user(Model model, Principal principal) {
        model.addAttribute("user", List.of(userService.getUserByName(principal.getName())));
        return "user";
    }


    @GetMapping(value = {"/admin"})
    public String allUsers(Model model) {
        List<User> AllUsers = userService.getAllUsers();
        model.addAttribute("allusers", AllUsers);
        return "admin";
    }

    @RequestMapping(value = "/remove/{id}")
    public String removeUser(@PathVariable(value = "id") int id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }

    @GetMapping(value = {"/add"})
    public String addNewUserGet(@ModelAttribute("newUser") User user) {
        return "addUser";
    }

    @PostMapping("/add")
    public String createNewUser(@ModelAttribute User user, Model model) {
        userService.addUser(user);
        return "redirect:/admin";
    }

    @GetMapping(value = {"/edit/{id}"})
    public String editNewUserGet(Model model, @PathVariable(value = "id") int id) {
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "edit";
    }

    @PostMapping("/edit/{id}")
    public String editUser(@PathVariable("id") int id, String name, String surname, int age, String password, Model model) {
        userService.editUser(id, name, surname, age, password);
        return "redirect:/admin";
    }

}
