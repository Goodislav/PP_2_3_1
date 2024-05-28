package web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import web.model.User;
import web.service.UserService;

import javax.annotation.PostConstruct;

@Configuration
public class DataInitializer {
    @Autowired
    private UserService userService;

    @PostConstruct
    public void init() {
        userService.addUser(new User("User1", "Lastname1", 20, "a@a.com", "1111"));
        userService.addUser(new User("User2", "Lastname2", 21, "b@b.com", "2222"));
        userService.addUser(new User("User3", "Lastname3", 22, "c@c.com", "3333"));
    }

}
