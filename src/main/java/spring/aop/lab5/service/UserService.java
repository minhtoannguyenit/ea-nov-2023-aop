package spring.aop.lab5.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import spring.aop.lab5.entity.User;
import spring.aop.lab5.repository.UserRepo;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepo userRepo;

    public List<User> getUsers() {
        return userRepo.findAll();
    }

    public User createUser(User user) {
        return userRepo.save(user);
    }
}
