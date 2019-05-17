package pl.kocie_stopki.kocie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.kocie_stopki.kocie.entity.User;

@Repository("/userRepository")
public interface UserRepo extends CrudRepository<User, Integer> {

    User findByemail(String email);

}
