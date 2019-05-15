package pl.kocie_stopki.kocie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kocie_stopki.kocie.entity.User;

@Repository("/userRepository")
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmail(String email);
}
