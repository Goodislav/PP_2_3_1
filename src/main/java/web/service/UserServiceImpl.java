package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private static int USERS_COUNT;
    @Autowired
    private UserDao userDao;
    private List<User> users = new ArrayList<>();
    {
        users.add(new User(++USERS_COUNT, "User1", "Lastname1", 20, "a@a.com", "1111"));
        users.add(new User(++USERS_COUNT,"User2", "Lastname2", 21, "b@b.com", "2222"));
        users.add(new User(++USERS_COUNT,"User3", "Lastname3", 22, "c@c.com", "3333"));
    }
    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return new ArrayList<>(users);
    }

    @Override
    @Transactional(readOnly = true)
    public User showUser(int id) {
        return userDao.showUser(id);
    }

    @Override
    public void updateUser(int id, User user) {
        userDao.updateUser(id, user);
    }

    @Override
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }
}
