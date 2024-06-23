package web.dao;

import org.springframework.stereotype.Component;
import web.models.User;

import java.util.ArrayList;
import java.util.List;
@Component
public class UserDaoImpl implements UserDao {
    private List<User> users;

    {
        users = new ArrayList<>();
        users.add(new User("User1", 10, 1));
        users.add(new User("User2", 20, 2));
        users.add(new User("User3", 30, 3));
        users.add(new User("User4", 40, 4));
        users.add(new User("User5", 50, 5));
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }


}
