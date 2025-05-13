package ru.test.site.controllers;

import org.springframework.web.bind.annotation.*;
import ru.test.site.model.User;
import ru.test.site.service.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable long id) {
        return userService.getUserById(id);
    }

    @PostMapping("save")
    public String addUser(@RequestBody User user) {
        if(user != null) {
            userService.addUser(user);
            return "User successfully added";
        }
        return "User data is null";
    }
}
