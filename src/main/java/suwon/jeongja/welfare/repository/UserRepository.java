package suwon.jeongja.welfare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import suwon.jeongja.welfare.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
