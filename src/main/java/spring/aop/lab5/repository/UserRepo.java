package spring.aop.lab5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.aop.lab5.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{
}
