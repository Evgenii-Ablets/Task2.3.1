package web.service;

import web.models.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();


    User getUserById(long id);

    void updateUser(User user);

    void deleteUser(User user);

    void addUser(User user);
}
