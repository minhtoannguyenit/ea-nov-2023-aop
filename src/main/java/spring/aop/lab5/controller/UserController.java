package spring.aop.lab5.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.aop.lab5.aop.ExecutionTime;
import spring.aop.lab5.entity.User;
import spring.aop.lab5.service.UserService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("users")
public class UserController {
    private final UserService userService;

    @ExecutionTime
    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @ExecutionTime
    @PostMapping
    public User createUser(User user) {
        return userService.createUser(user);
    }
}
