package web.dao;

import org.springframework.stereotype.Repository;
import web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public User getUserById(long id) {
        User user = entityManager.find(User.class, id);
        if (user == null) {
            throw new EntityNotFoundException("User not found");
        }
        return user;
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(User user) {
        User userFromDB = entityManager.find(User.class, user.getId());
        if (userFromDB == null) {
            throw new EntityNotFoundException("User not found");
        }
        entityManager.merge(entityManager.contains(user) ? user : entityManager.merge(user));
    }

    @Override
    public void deleteUser(User user) {
        User userFromDB = entityManager.find(User.class, user.getId());
        if (userFromDB == null) {
            throw new EntityNotFoundException("User not found");
        }
        entityManager.remove(entityManager.contains(user) ? user : entityManager.merge(user));
    }
}

