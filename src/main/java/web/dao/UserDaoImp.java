package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("FROM User", User.class).getResultList();
    }

    @Override
    public User showUser(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void updateUser(int id, User user) {
        User updateUser = entityManager.find(User.class, id);
        if (updateUser != null) {
            updateUser.setName(user.getName());
            updateUser.setAge(user.getAge());
            entityManager.merge(updateUser);
        }
    }

    @Override
    public void deleteUser(int id) {
        User deleteUser = entityManager.find(User.class, id);
        if (deleteUser != null) {
            entityManager.remove(deleteUser);
        }
    }
}
