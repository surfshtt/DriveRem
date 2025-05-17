package ru.test.site.service.User;

import ru.test.site.model.User;

import java.util.List;

public interface UserService {
    User getUserById(long id);
    void addUser(User user);
    List<User> getAllUsers();
    User getUserByUsername(String username);
    boolean checkTelegram(String telegram);
}
