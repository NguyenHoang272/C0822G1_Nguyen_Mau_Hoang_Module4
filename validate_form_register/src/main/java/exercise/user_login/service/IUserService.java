package exercise.user_login.service;

import exercise.user_login.model.User;

import java.util.List;

public interface IUserService {
    List<User> finALL();

    void save(User user);
}
