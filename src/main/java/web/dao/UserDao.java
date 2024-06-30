package web.dao;

import web.models.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();


    User getUserById(long id);

    void updateUser(User user);

    void deleteUser(User user);
    void addUser(User user);
}
