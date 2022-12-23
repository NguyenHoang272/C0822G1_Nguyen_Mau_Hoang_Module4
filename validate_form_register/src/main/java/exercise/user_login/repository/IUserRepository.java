package exercise.user_login.repository;

import exercise.user_login.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Integer> {
}
