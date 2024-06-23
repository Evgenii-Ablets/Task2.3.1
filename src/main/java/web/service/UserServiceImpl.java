package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.dao.UserDaoImpl;
import web.models.User;

import java.util.List;


@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDaoImpl userDao;


    @Override
    public List<User> getUsers() {
        return userDao.getAllUsers();
    }


}
