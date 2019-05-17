package pl.kocie_stopki.kocie.repository;

        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.stereotype.Repository;
        import pl.kocie_stopki.kocie.entity.User;
/**
 * Thic class is a repostitory for users. It provides create, remove, uptdate, delete functions.
 */
@Repository("/userRepository")
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEMail(String email);
}
