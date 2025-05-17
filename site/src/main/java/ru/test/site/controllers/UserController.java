package ru.test.site.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.test.site.model.User;
import ru.test.site.repository.UserRepository;
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

    @GetMapping("/id/{id}")
    public User getUserById(@PathVariable long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/username/{username}")
    public User getUseBryUsername(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }

    @PostMapping("save")
    public ResponseEntity<String> addUser(@RequestBody User user) {
        if(validateUserData(user)) {
            userService.addUser(user);
            return ResponseEntity.ok("User successfully added");
        }
        else {
            return ResponseEntity.badRequest().body("User data is incorrect");
        }
    }


    private boolean validateUserData(User user){

        if(user == null)
            return false;

        if(userService.getUserByUsername(user.username) != null)
            return false;

        if(userService.checkTelegram(user.telegramId))
            return false;

        return true;
    }
}
