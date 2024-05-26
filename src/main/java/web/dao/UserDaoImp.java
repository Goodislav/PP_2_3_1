package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Override
    public void add(User user) {
    }

    @Override
    public List<User> listUsers() {
        return null;
    }

}
