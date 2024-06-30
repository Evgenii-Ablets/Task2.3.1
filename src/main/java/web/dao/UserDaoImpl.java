package web.dao;

import org.springframework.stereotype.Repository;
import web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import java.util.List;
//@Component
//public class UserDaoImpl implements UserDao {
//    private List<User> users;
//    private static int COUNT = 0;
//
//    {
//        users = new ArrayList<>();
//        users.add(new User("User1", 10, ++COUNT));
//        users.add(new User("User2", 20, ++COUNT));
//        users.add(new User("User3", 30, ++COUNT));
//        users.add(new User("User4", 40, ++COUNT));
//        users.add(new User("User5", 50, ++COUNT));
//    }
//
//    @Override
//    public List<User> getAllUsers() {
//        return users;
//    }
//
//
//    @Override
//    public User getUserById(int id) {
//        return users.stream().filter(user -> user.getId() == id).findAny().orElse(null);
//    }
//
//    @Override
//    public void updateUser(User updatedUser) {
//        User user = getUserById(updatedUser.getId());
//        user.setName(updatedUser.getName());
//        user.setAge(updatedUser.getAge());
//    }
//
//    @Override
//    public void deleteUser(int id) {
//
//    }
//    @Override
//    public void addUser(User user) {
//        user.setId(++COUNT);
//        users.add(user);
//    }


//    @Repository
//    public class UserDaoImpl implements UserDao {
//
//        @PersistenceContext(type = PersistenceContextType.EXTENDED)
//        private EntityManager em;
//
//        @Override
//        public List<User> showAllEmployee() {
//            return em.createQuery("from User", User.class).getResultList();
//        }
//
//        @Override
//        public User getUserById(int id) {
//            return em.find(User.class, id);
//        }
//
//        @Override
//        public void addUser(User user) {
//            em.persist(user);
//        }
//
//        @Override
//        public void updateUser(int id, User user) {
//            em.merge(user);
//        }
//
//        @Override
//        public void delete(int id) {
//            Employee employee = em.find(Employee.class, id);
//            if (employee != null) {
//                em.remove(em.find(Employee.class, id));
//            }
//
//        }
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
        return entityManager.find(User.class, id);
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(entityManager.contains(user) ? user : entityManager.merge(user));
    }

    @Override
    public void deleteUser(User user) {
        entityManager.remove(entityManager.contains(user) ? user : entityManager.merge(user));
    }
}

