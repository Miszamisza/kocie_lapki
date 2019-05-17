package pl.kocie_stopki.kocie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.kocie_stopki.kocie.entity.Order;
import pl.kocie_stopki.kocie.entity.User;
import pl.kocie_stopki.kocie.registration.validator.EmailPass;
import pl.kocie_stopki.kocie.registration.validator.PassMatch;
/**
 * Thic class is a repostitory for users. It provides create, remove, uptdate, delete functions.
 */
@Repository("/orderRepository")
public interface OrderRepo extends CrudRepository<Order, Integer> {


}
