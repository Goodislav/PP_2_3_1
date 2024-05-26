package web.service;

import org.springframework.stereotype.Service;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public List<User> getAllUsers() {
        return null;
    }
}
