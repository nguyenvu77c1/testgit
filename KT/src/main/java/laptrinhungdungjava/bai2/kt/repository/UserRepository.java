package laptrinhungdungjava.bai2.kt.repository;

import laptrinhungdungjava.bai2.kt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
