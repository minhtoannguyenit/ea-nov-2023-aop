package spring.aop.lab5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.aop.lab5.entity.ActivityLog;

@Repository
public interface ActivityLogRepo extends JpaRepository<ActivityLog, Long> {
}
