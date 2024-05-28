package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/addUser")
    public String addUser(@RequestParam String name, @RequestParam String email) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        userService.addUser(user);
        return "redirect:/users";
    }
    @GetMapping
    public ModelAndView getAllUsers() {
        List<User> users = userService.getAllUsers();
        ModelAndView modelAndView = new ModelAndView("users");
        modelAndView.addObject("users", users);
        return modelAndView;
    }
    @PostMapping("/updateUser")
    public String updateUser(@RequestParam int id, @RequestParam String name, @RequestParam String lastname,
                             @RequestParam int age, @RequestParam String email, @RequestParam String password) {
        User user = userService.showUser(id);
        if (user != null) {
            user.setName(name);
            user.setLastname(lastname);
            user.setAge(age);
            user.setEmail(email);
            user.setPassword(password);
            userService.updateUser(id, user);
        }
        return "redirect:/users";
    }
    @GetMapping("/edit")
    public ModelAndView editUser(@RequestParam int id) {
        User user = userService.showUser(id);
        ModelAndView modelAndView = new ModelAndView("editUser");
        modelAndView.addObject("user", user);
        return modelAndView;
    }
    @PostMapping("/delete")
    public String deleteUser(@RequestParam int id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}