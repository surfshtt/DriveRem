package ru.test.site.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.test.site.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserById(long id);
}
