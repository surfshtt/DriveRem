package ru.test.site.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.test.site.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    boolean existsByTelegramId(String telegramId);
    //User findByTelegramId(String telegramId);
    //User findByEmail(String telegramId);
    //User findById(long id);
}
